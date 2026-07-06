package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.GetMutterListService;
import com.example.demo.model.Mutter;
import com.example.demo.model.PostMutterLogic;
import com.example.demo.model.User;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {

	private final GetMutterListService getMutterListService;
    private final PostMutterLogic postMutterLogic;

    @GetMapping("/Main")
    public String showMain(HttpSession session, Model model) {

        User loginUser =
                (User) session.getAttribute("loginUser");

        System.out.println("loginUser id = " + loginUser.getId());
        System.out.println("loginUser name = " + loginUser.getName());
        if (loginUser == null) {
            return "redirect:/";
        }

        List<Mutter> mutterList =
                getMutterListService.execute();

        LocalDateTime lastReadTime =
                (LocalDateTime) session.getAttribute("lastReadTime");

        model.addAttribute("mutterList", mutterList);
        model.addAttribute("lastReadTime", lastReadTime);

        session.setAttribute("lastReadTime", LocalDateTime.now());

        return "main";
    }

    @PostMapping("/Main")
    public String postMain(
            @RequestParam(required = false) String text,
            @RequestParam(required = false) MultipartFile image,
            HttpSession session,
            Model model) throws IOException {

        User loginUser =
                (User) session.getAttribute("loginUser");

        if (loginUser == null) {
            return "redirect:/";
        }

        String imagePath = null;

        if (image != null && !image.isEmpty()) {

            String fileName =
                    Paths.get(image.getOriginalFilename())
                            .getFileName()
                            .toString();

            String savedFileName =
                    System.currentTimeMillis() + "_" + fileName;

            String uploadPath = "src/main/webapp/upload";

            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            image.transferTo(
                    new File(uploadDir, savedFileName));

            imagePath = "upload/" + savedFileName;
        }

        if ((text != null && !text.isBlank()) || imagePath != null) {

            Mutter mutter =
                    new Mutter(
                            loginUser.getId(),
                            loginUser.getName(),
                            text);

            mutter.setImagePath(imagePath);

            boolean result = postMutterLogic.execute(mutter);

            System.out.println("投稿結果 = " + result);
            System.out.println("text = " + text);
            System.out.println("imagePath = " + imagePath);

            return "redirect:/Main";

        } else {

            List<Mutter> mutterList =
                    getMutterListService.execute();

            LocalDateTime lastReadTime =
                    (LocalDateTime) session.getAttribute("lastReadTime");

            model.addAttribute("mutterList", mutterList);
            model.addAttribute("lastReadTime", lastReadTime);
            model.addAttribute(
                    "errorMsg",
                    "つぶやきまたは画像を入力してください");

            return "main";
        }
    }
}
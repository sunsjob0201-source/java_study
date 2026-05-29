package thread;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class FutureComplete {

    public static void main(String[] args) {

        CompletableFuture.supplyAsync(() -> {
            var r = new Random();
            var num = r.nextInt(1000);
            heavy(num);
            return num;
        })
        .whenCompleteAsync((result, ex) -> {
            if (ex == null) {
                System.out.println(result);
            } else {
                System.out.println(ex.getMessage());
            }
        });

        System.out.println("メイン処理");

        heavy(2000);
    }

    public static void heavy(int num) {
        try {
            Thread.sleep(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// package thread;
//
// import java.util.concurrent.CompletableFuture;
//
// public class FutureComplete {
//
//     public static void main(String[] args) {
//
//         CompletableFuture.supplyAsync(() -> {
//
//             return "処理完了";
//
//         }).whenCompleteAsync((result, ex) -> {
//
//             if (ex == null) {
//                 System.out.println(result);
//             } else {
//                 System.out.println(ex.getMessage());
//             }
//
//         });
//
//         System.out.println("メイン処理");
//
//         try {
//             Thread.sleep(1000);
//         } catch (InterruptedException e) {
//             e.printStackTrace();
//         }
//     }
// }

// package thread;
//
// import java.util.concurrent.CompletableFuture;
//
// public class FutureComplete {
//
//     public static void main(String[] args) {
//
//         CompletableFuture.supplyAsync(() -> {
//
//             return "処理完了";
//
//         }).whenCompleteAsync((result, ex) -> {
//
//             if (ex == null) {
//                 System.out.println(result);
//             } else {
//                 System.out.println(ex.getMessage());
//             }
//
//         });
//
//         System.out.println("メイン処理");
//
//         try {
//             Thread.sleep(1000);
//         } catch (InterruptedException e) {
//             e.printStackTrace();
//         }
//     }
// }
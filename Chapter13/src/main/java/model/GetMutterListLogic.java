package model;

import java.util.List;

import dao.MuttersDao;

public class GetMutterListLogic {
    public List<Mutter> execute() {
        MuttersDao dao = new MuttersDao();
        List<Mutter> mutterList = dao.findAll();
        return mutterList;
    }
}

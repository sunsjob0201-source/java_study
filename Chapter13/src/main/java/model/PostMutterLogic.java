package model;

import dao.MuttersDao;

public class PostMutterLogic {
  public void execute(Mutter mutter) {
	  MuttersDao dao = new MuttersDao();
	  dao.create(mutter);
  }
}

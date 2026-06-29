package model;

import java.util.List;

public class EjDictLogic {
    public List<EjDict> execute(String word, int maxCount) {
    	DictionaryDAO dao = new DictionaryDAO();
    	
    	List<EjDict> ejDictList = dao.findByWord(word, maxCount);
    	
    	return ejDictList;

    }
}
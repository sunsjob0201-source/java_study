package record;


 public record Person(String name, int age) {}

// ↓こんな感じ
// public final class Person {
//
//	    private final String name;
//	    private final int age;
//
//	    public Person(String name, int age) {
//	        this.name = name;
//	        this.age = age;
//	    }
//
//	    public String name() {
//	        return name;
//	    }
//
//	    public int age() {
//	        return age;
//	    }
//
//	    @Override
//	    public String toString() {
//	        ...
//	    }
//
//	    @Override
//	    public boolean equals(Object obj) {
//	        ...
//	    }
//
//	    @Override
//	    public int hashCode() {
//	        ...
//	    }
//	}
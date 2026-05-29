package thread;

public class SynchronizedUse {
  void increment() {
  synchronized(this) {
	  this.value++;
  }
}
}

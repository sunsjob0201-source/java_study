package rekkyo;

public enum Season2 {

    SPRING {
        @Override
        public void show() {
            System.out.println("春はあけぼの");
        }
    },

    SUMMER {
        @Override
        public void show() {
            System.out.println("夏は夜");
        }
    },

    AUTUMN {
        @Override
        public void show() {
            System.out.println("秋は夕暮れ");
        }
    },

    WINTER {
        @Override
        public void show() {
            System.out.println("冬はつとめて");
        }
    };

    public abstract void show();
}
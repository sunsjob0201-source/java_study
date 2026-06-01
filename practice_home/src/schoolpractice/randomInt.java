package schoolpractice;

public class randomInt {

    public static void main(String[] args) {

        int[][] p = new int[5][4];

        // ランダム値を代入
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p[i].length; j++) {
                p[i][j] = (int)(Math.random() * 11);
            }
        }

        // 表示
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p[i].length; j++) {
                System.out.print(p[i][j] + "\t");
            }
            System.out.println();
        }

        // 区切り線
        System.out.println("----------------");

        // 列ごとの合計
        for (int j = 0; j < p[0].length; j++) {

            int sum = 0;

            for (int i = 0; i < p.length; i++) {
                sum += p[i][j];
            }

            System.out.print(sum + "\t");
        }
    }
}
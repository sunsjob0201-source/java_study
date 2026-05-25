package rekkyo;

public class EnumSeason {

    public void processSeason(Season season) {
        System.out.println(season);
    }

    public static void main(String[] args) {

        EnumSeason es = new EnumSeason();

        es.processSeason(Season.SPRING);
        es.processSeason(Season.SUMMER);

        System.out.println(Season.AUTUMN.toSeasonValue());
    }
}
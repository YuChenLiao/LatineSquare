package sample;

public class Latine {
    public static class LatineInfo{
        String text;
        String pic;
        String color;
        public LatineInfo(String a) {
            this.text = "";
            this.pic = "";
            this.color = "";
        }
    }
    public static LatineInfo[][] generateLatine(int n){
        System.out.println("调用");
        if (n<=0)
            return null;
        LatineInfo[][] cards = new LatineInfo[n][];
        for (int i = 0;i < n;i++) {
            cards[i] = new LatineInfo[n];
            for (int j = 0;j < n;j++) {
                cards[i][j] = new LatineInfo("");
            }
        }
        String[] cl = {"#dd7e6b","#cfe2f3","#d9ead3","#f4cccc"};
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n;j++){
                cards[i][j].color = switch ((i+j)%4) {
                    case 0-> cl[0];
                    case 1-> cl[1];
                    case 2-> cl[2];
                    case 3-> cl[3];
                    default -> " ";
                };
                cards[i][j].text = switch ((i+j)%n+1) {
                    case 1->"A";
                    case 11->"J";
                    case 12->"Q";
                    case 13->"K";
                    default ->String.valueOf((i+j)%n+1);
                };
                cards[i][j].pic = switch ((i+j)%4) {
                    case 0->"♣";
                    case 1->"♠";
                    case 2->"♥";
                    case 3->"♦";
                    default -> " ";
                };
            }
        }
        return cards;
    }
}
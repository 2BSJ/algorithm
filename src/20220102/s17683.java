public class s17683 {
    public static void main(String[] args) {
        s17683 problem = new s17683();
        String m = "ABCDEFG";
        String[] musicinfos = new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(problem.solution(m, musicinfos));
    }

    public String solution(String m, String[] musicinfos) {

        m = replaceMelody(m);

        int correspondingMusicTime = 0;
        String correspondingMusicTitle = "";

        for (int i = 0; i < musicinfos.length; i++) {
            String musicInfo[] = musicinfos[i].split(",");
            int playingTime = getPlayingTime(musicInfo[1], musicInfo[0]);
            String title = musicInfo[2];
            String melody = replaceMelody(musicInfo[3]);

            StringBuilder wholeMelodySB = new StringBuilder();

            int remainTime = playingTime;
            int melodyIdx = 0;
            while (remainTime != 0) {
                remainTime--;
                wholeMelodySB.append(melody.charAt(melodyIdx++));
                if (melody.length() == melodyIdx) {
                    melodyIdx = 0;
                }
            }

            if(correspondingMusicTime < playingTime
                    && wholeMelodySB.toString().contains(m)) {
                correspondingMusicTime = playingTime;
                correspondingMusicTitle = title;
            }
        }

        return correspondingMusicTitle.equals("") ? "(None)" : correspondingMusicTitle;
    }

    private String replaceMelody(String melody) {

        return melody.replaceAll("C#", "1").replaceAll("D#", "2").replaceAll("F#", "3")
                .replaceAll("G#", "4").replaceAll("A#", "5");
    }

    private int getPlayingTime(String t1, String t2) {

        String time1 []= t1.split(":");
        String time2 []= t2.split(":");

        int playHour = Integer.parseInt(time1[0]) - Integer.parseInt(time2[0]);
        int playMinute = Integer.parseInt(time1[1]) - Integer.parseInt(time2[1]);

        return playHour * 60 + playMinute;
    }

}

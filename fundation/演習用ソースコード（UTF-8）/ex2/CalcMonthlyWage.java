import java.sql.Time;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;

public class CalcMonthlyWage {

    public static void main(String[] args) {

        int sum = 0;

        //  WorkingResult.csvのパス ※「C:\WorkSpace」直下に配置していない場合は適宜変更してください。
        final String WORKING_RESULT_FILE_PATH = "/Users/uuu/projects/udemy/javaBasic/fundation/演習用ソースコード（UTF-8）/ex2/WorkingResult.csv";
        // コンマ
        final String COMMA = ",";

        List<String> workingResults = new ArrayList<String>(); //ファイルから読み込んだデータの格納用

        //  WorkingResult.csvを読み込む
        try {
            // WorkingResult.csvの読み込み準備
            File workingResultFile = new File(WORKING_RESULT_FILE_PATH);
            BufferedReader br = new BufferedReader(new FileReader(workingResultFile));

            // WorkingResult.csvを1行ずつ読み込んでArrayListに格納する
            String recode = br.readLine();
            while (recode != null) {
                workingResults.add(recode);
                recode = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        // ArrayListから1行ずつ取り出して日付/出勤時間/退勤時間に振り分け
        for (int i = 0; i < workingResults.size() ; i++) {

            String workingRecode    = workingResults.get(i);      // 1行ずつ文字列を取り出す
            String[] forSplitRecode = workingRecode.split(COMMA); // splitメソッドを用いてカンマ区切りで文字列を分解＆配列にそれぞれ格納

            Time startTime   = Time.valueOf(forSplitRecode[1]); // 出勤時間
            Time finishTime  = Time.valueOf(forSplitRecode[2]); // 退勤時間

            sum += calcDailyWAge(startTime, finishTime);
        }
        // 出力
        System.out.println(sum);
    }

    private static int calcDailyWAge (Time start, Time finish){

        // 計算用の数値を定数で用意
        final long ONE_HOUR_BY_MILLI_SEC = 1000 * 60 * 60; // 1時間のミリ秒換算
        final long ONE_MIN_BY_MILLI_SEC = 1000 * 60;      // 1分のミリ秒換算
        final int ONE_HOUR_BY_MIN = 60;             // 1時間の分換算

        //バイト給与計算用定数
        final int SHORT_BREAK = 45;      // 小休憩の分換算;
        final int LONG_BREAK = 60;      // 大休憩の分換算;
        final int BREAK_TIME_THRESHOLD = 6 * 1000 * 60 * 60; // 6時間のミリ秒換算
        final int OVER_TIME_PAY_THRESHOLD = 8 * 1000 * 60 * 60; // 8時間のミリ秒換算

        // バイトの開始時間と終了時間を引数から受け取る
        Time startTime = start;
        Time finishTime = finish;

        // getTimeメソッドを使って労働時間をミリ秒（0.001秒単位）で取得する
        // ※getTime()メソッドの戻り値はlong型であることに注意
        long workingTime = finishTime.getTime() - startTime.getTime();

        // ミリ秒で取得した労働時間を○時間△分の形式に直す
        int workingHour = (int) (workingTime / ONE_HOUR_BY_MILLI_SEC);    // 時間に換算
        int workingMin = (int) ((workingTime / ONE_MIN_BY_MILLI_SEC)); // 分に換算

        // 出力
        if (workingTime < BREAK_TIME_THRESHOLD) {
            int wage = workingMin * (900 / 60);
            return wage;

        } else if (workingTime < OVER_TIME_PAY_THRESHOLD) {
            int wage = (workingMin - SHORT_BREAK) * (900 / 60);
            return wage;
        } else {
            workingMin -= LONG_BREAK;
            int overTimeWorkingMin = 0;
            if (workingMin - 8 * 60 > 0) {
                overTimeWorkingMin = (workingMin - 8 * 60);
            }
            int wage = ((workingMin - overTimeWorkingMin) * (900 / 60)) + (int)(overTimeWorkingMin * (900 * 1.25 / 60));
            return wage;
        }
    }
}

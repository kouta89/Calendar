import java.util.Calendar;

public class Main{
	public static void main(String[] args) {
		
		//実行時の日付と時刻の情報を取得
		Calendar ca = Calendar.getInstance();
		
		int year = ca.get(Calendar.YEAR);
		int month = ca.get(Calendar.MONTH) + 1;
		int date = ca.get(Calendar.DATE);
		System.out.println("本日の日付: "+year+"年"+month+"月"+date+"日");
		
		//インタンスの持つ日付情報を1日に変更
		ca.set(Calendar.DATE, 1);
		System.out.println("DATE: "+ ca.get(Calendar.DATE));
		
		//先週の最終日が何曜日だったかを取得
		int beforeDay=ca.get(Calendar.DAY_OF_WEEK)-1;
		System.out.println(beforeDay);
		
		//その月の月末までの日数を取得
		int daysCount=ca.getActualMaximum(Calendar.DATE);
		System.out.println(daysCount);
		
		for(int i=1;i <= beforeDay + daysCount;i++) {
			
			int days = i - beforeDay;
			
			
			if(days > 0) {
				System.out.printf("%4s", days);
			}else {
				System.out.printf("%4s", " ");
			}
			
			if(i % 7 == 0) {
				//days
				System.out.println();
			}
		}
		
	}
}
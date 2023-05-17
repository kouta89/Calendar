import java.util.Calendar;

public class Main{
	public static void main(String[] args) {
		
		//実行時の日付と時刻の情報を取得
		Calendar ca = Calendar.getInstance();
		
		//本日の日付情報
		int year = ca.get(Calendar.YEAR);
		int month = ca.get(Calendar.MONTH) + 1;
		int date = ca.get(Calendar.DATE);
		String[] weeks= {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
		
		System.out.println("本日の日付: "+year+"年"+month+"月"+date+"日"+ getDayOfTheWeekNow());
		
		//その月の月末までの日数を取得
		int daysCount=ca.getActualMaximum(Calendar.DATE);
		
		//カレンダーに記載しない一日以前の日数を取得
		ca.set(Calendar.DATE, 1);
		int beforeBlank=ca.get(Calendar.DAY_OF_WEEK)-1;
		
		//色を設定
		String red    = "\u001b[00;31m";
		String cyan   = "\u001b[00;36m";
		String yellow = "\u001b[00;33m";
		String pink   = "\u001b[00;35m";
		String end    = "\u001b[00m";//終止符
		String[] colors= {red,cyan,yellow,pink};
		
		//曜日表示
		for(int j=0;j < weeks.length;j++) {
			String colorDays = colors[2] + weeks[j] + end;
			System.out.printf(" " + colorDays);
		}
		System.out.println();
		
		//日付表示
		for(int i=1;i <= beforeBlank + daysCount;i++) {
			
			int days = i - beforeBlank;
			
			//daysが0の時表示しない
			if(days > 0) {
				
				//日付が一桁の場合空白を3つ、二桁の場合空白を2つ用意
				if(days < 10) {
					if(days == date){
						System.out.printf("   " + colors[3] + days + end);
					}else if(i%7 == 1) {
						System.out.printf("   " + colors[0] + days + end);
					}else if(i%7 == 0){
						System.out.printf("   " + colors[1] + days + end);
					}
					else {
						System.out.printf("   " + days);
					}
				}else {
					if(days == date){
						System.out.printf("  " + colors[3] + days + end);
					}else if((i%7) == 1) {
						System.out.printf("  " + colors[0] + days + end);
					}else if((i%7) == 0){
						System.out.printf("  " + colors[1] + days + end);
					}
					else {
						System.out.printf("  " + days);
					}
				}
				
			}else {
				System.out.printf("%4s", " ");
			}
	
			
			if(i % 7 == 0) {
				//days
				System.out.println();
			}
		}
		
	}
	
	//現在の曜日を返します。
	public static String getDayOfTheWeekNow() { 
	    Calendar cal = Calendar.getInstance(); 
	    switch (cal.get(Calendar.DAY_OF_WEEK)) {
	        case Calendar.SUNDAY: return "日曜日";
	        case Calendar.MONDAY: return "月曜日";
	        case Calendar.TUESDAY: return "火曜日";
	        case Calendar.WEDNESDAY: return "水曜日";
	        case Calendar.THURSDAY: return "木曜日";
	        case Calendar.FRIDAY: return "金曜日";
	        case Calendar.SATURDAY: return "土曜日";
	    }
	    throw new IllegalStateException();
	}
	
}
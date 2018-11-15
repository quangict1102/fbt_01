package app.helper;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ConvertDateSql {
	public static Date convertDateSql(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dateUtil = null;
		try {
			dateUtil = dateFormat.parse(String.valueOf(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date dateSql = new Date(dateUtil.getTime());
		return dateSql;
	}
}

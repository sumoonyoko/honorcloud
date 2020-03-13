package org.honorcloud.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description: 时间工具类
 * @version: v1.0.0
 * @author: sumoonyoko
 * @date: 2019年11月06日 
 */
public class DateUtils {

	public final static String PATTERN_YYMM="yyyyMM";
	public final static String PATTERN_YYMMDD="yyyyMMdd";
	public final static String PATTERN_YY_MM_DD = "yyyy-MM-dd";
	public final static String PATTERN_YMDHM="yyyyMMdd HH:mm";
	public final static String PATTERN_YMDHMS="yyyy-MM-dd HH:mm:ss";
	public final static String PATTERN_USERCODE="yyyyMMddHHmmss";

	public static String formatTodayYMD() {
		return formatYMD(new Date());
	}
	public static String formatTodayYM() {
		return formatYM(new Date());
	}

	public static String formatYM(Date curDate) {
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_YYMM);
		return sdf.format(curDate);
	}

	public static String formatYMDHM(Date curDate) {
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_YMDHM);
		return sdf.format(curDate);
	}

	public static String formatYMD(Date curDate) {
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_YYMMDD);
		return sdf.format(curDate);
	}
	public static String formatYMD_(Date curDate) {
		if(curDate == null){
			curDate = new Date();
		}
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_YY_MM_DD);
		return sdf.format(curDate);
	}

	public static String formatYMDHMS(Date curDate) {
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_YMDHMS);
		return sdf.format(curDate);
	}
	public static String formatUsercode(Date curDate) {
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_USERCODE);
		return sdf.format(curDate);
	}
	public static Date praseDate(String curDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_YMDHMS);
		return sdf.parse(curDate);
	}
	public static Date getDateFromMills(Long secodes)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(secodes);
		return cal.getTime();
	}
	
	public static String addHour(String curDate,int hour) throws ParseException
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(praseDate(curDate));

		cal.add(Calendar.HOUR_OF_DAY, hour);

		return formatYMDHMS(cal.getTime());
	}
	
	/**
	 * 根据传入的日期和天数计算日期
	 * @param date Date 为null，则为当前系统日期
	 * @param day int 需要增加的天数
	 * @return Date
	 * @throws ParseException
	 */
	public static Date addDay(Date date, int day){
		if(date == null) {
			date = new Date();
		}
		long times = date.getTime() + (day * 24 * 60 * 60 * 1000);
		return new Date(times);
	}

	public static Date addMinute(Date curDate,int minute)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(curDate);
		cal.add(Calendar.MINUTE, minute);
		return cal.getTime();
	}

	public static Date getCurrentMinute()
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.SECOND,0);
		return cal.getTime();
	}

	/**
	 * 日期转字符串
	 *
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date) {
		return DateUtils.formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 日期转字符串
	 *
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDate(Date date, String format) {
		if (null == date) return null;
		if (null == format || "".equals(format)) return null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * 字符串转日期，格式为："yyyy-MM-dd HH:mm:ss"
	 *
	 * @param dateStr
	 * @return
	 */
	public static Date formatDate(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date result = null;
		try {
			result = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 字符串转日期，格式为："yyyy-MM-dd HH:mm:ss"
	 *
	 * @param dateStr
	 * @return
	 */
	public static Date formatDate(String dateStr, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date result = null;
		try {
			result = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 获取当前时间戳
	 *
	 * @return
	 */
	public static Long curTimeStamp() {
		return System.currentTimeMillis();
	}

	/**
	 * 日期转时间戳
	 *
	 * @param date
	 * @return
	 */
	public static Long transForMillis(Date date) {
		if (date == null) return null;
		return date.getTime();
	}

	/**
	 * 日期字符串转时间戳
	 *
	 * @param dateStr
	 * @return
	 */
	public static Long transForMillis(String dateStr) {
		Date date = DateUtils.formatDate(dateStr);
		return date == null ? null : DateUtils.transForMillis(date);
	}

	/**
	 * 日期字符串转时间戳
	 *
	 * @param dateStr
	 * @return
	 */
	public static Long transForMillis(String dateStr, String format) {
		Date date = DateUtils.formatDate(dateStr, format);
		return date == null ? null : DateUtils.transForMillis(date);
	}
	
	public static void main(String[] args) throws ParseException {
		System.out.println(DateUtils.formatDate(DateUtils.addDay(null, 2)));
	}

}

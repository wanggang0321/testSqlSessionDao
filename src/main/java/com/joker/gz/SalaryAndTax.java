package com.joker.gz;

/**
 * @author wanggang
 * @date 2018年5月13日 下午4:18:41
 * 个人所得税计算
 */
public class SalaryAndTax {
	
	//各项社会保险费
	private static final float jf = 314.76f;
	//起征点
	private static final int b = 3500;
	
	public static void main(String[] args) {
		float a201701 = 25.39f;
		calcSalary(a201701);
	}
	
	//应纳税所得额范围
	//不超过1500元的，应缴税款：<45
	//超过1500元至4,500元的部分，应缴税款：45 ~ 345
	//超过4,500元至9,000元的部分，应缴税款：345 ~ 1245
	//超过9,000元至35,000元的部分，应缴税款：1245 ~ 7745
	
	private static void calcSalary(float tax) {
		
		//税前工资
		float c = 0.0f;
		
		//应纳税所得额
		float d = 0.0f;
		
		//适用税率
		float e = 0.0f;
		
		//实发工资
		float g = 0.0f;
		
		//速算扣除数
		int f = 0;
		
		if(tax<45) {
			e = 0.03f;
			f = 0;
		}else if(tax>45 && tax<=345) {
			e = 0.1f;
			f = 105;
		}else if(tax>345 && tax<=1245) {
			e = 0.2f;
			f = 555;
		}else if(tax>1245 && tax<=7745) {
			e = 0.25f;
			f = 1005;
		}
		
		d = (tax + f)/e;
		System.out.println("应纳税所得额：" + d);
		c = d + b + jf;
		System.out.println("税前工资：" + c);
		
		
		g = c - jf - tax;
		System.out.println("实发工资：" + g);
		
	}
	
}

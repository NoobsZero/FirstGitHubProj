package kgc.book.object;

import java.util.Scanner;

/**
 * 吃货联盟订餐管理系统
 * 
 * @author Show
 * 
 * 				"吃货联盟订餐系统"需求说明
 * 现今已进入网络时代，网上购物、看新闻、交友等人们的日常生活已离不开网络。“只
要点点手指，就能送餐上门”，网上定餐越来越受到都市年轻人的青睐 现要求开发一个
网上订餐系统，其具体功能如下：
一、我要订餐
完成用户订餐，每条订单包含如下信息：
 订餐人姓名：要求用户输入
 选择菜品及份数：显示三个菜单序号、名称、单价、点赞数，提示用户输入要
选择的菜品序号及份数
 送餐时间：要求当天 10 到 20 点间整点送餐，要求用户输入 10~20 的整数，输
入错误，重复输入。
 送餐地址：要求用户输入
 状态：两种状态：0：已预定（默认状态） 1、已完成（订单已签收）
 总金额：
总金额 = 菜品单价*份数-送餐费
（送餐费：当单笔订单金额达到 50 元时，免送餐费，否则，需交纳 6 元送餐费）
订餐成功后，显示订单信息。
二、 查看订单
遍历显示已有定单
内容包括：序号、订餐人姓名、订餐信息（菜品名和份数）、送餐时间、送餐地址、
状态（已预定或已完成）、总金额
三、 签收定单
将定单中状态改为已完成
四、删除定单
用户输入订单序号，如该序号定单为已完成状态，可以删除，其它情况给出相应提
示信息
五、我要点赞
显示菜品序号、菜品名、单价、点赞数，提示用户输入要点赞的菜品序号完成对菜
品的点赞。
六、退出系统
退出整个系统，显示“谢谢使用，欢迎下次光临”。
七、菜单切换
用户可根据显示的主菜单，输入功能编号执行相应的功能，当输入 1~5 时，执行相应功
能（如图 1 所示）。
 */
public class zhonghe {
	public static void main(String[] args) {
		// 数据主体：一组订单信息
		String[] names = new String[4]; // 订餐人名称
		String[] dishMegs = new String[4]; // 所选菜品
		int[] times = new int[4]; // 送餐日期
		String[] addresses = new String[4]; // 送餐地址
		int[] states = new int[4]; // 订单状态： 0：已预定 1：已完成
		double[] sumPrices = new double[4]; // 总金额
		
	
		
		// 供选择的菜品信息
		String[] dishNames = { "红烧带鱼", "鱼香肉丝", "时令鲜蔬" }; // 菜品名称
		double[] prices = new double[] { 38.0, 20.0, 10.0 }; // 菜品单价
		int[] praiseNums = new int[3];

		Scanner input = new Scanner(System.in);
		int num = -1; // 用户输入0返回主菜单，否则退出系统
		boolean isExit = false; // 标志用户是否退出系统： true:退出系统

		System.out.println("\n欢迎使用“吃货联盟订餐系统”");
		// 循环：显示菜单，根据用户选择的数字执行相应功能
		do {
			// 显示菜单			
			System.out.println("****************************");
			System.out.println("1、我要订餐");
			System.out.println("2、查看餐袋");
			System.out.println("3、签收订单");
			System.out.println("4、删除订单");
			System.out.println("5、我要点赞");
			System.out.println("6、退出系统");
			System.out.println("****************************");
			System.out.print("请选择：");
			int choose = input.nextInt(); // 记录用户选择的功能编号
			boolean isAdd = false;  //记录是否可以订餐
			boolean isSignFind = false;  //找到要签收的订单
			boolean isDelFind = false;  //找到要删除的订单
			// 根据用户选择的功能编号执行相应功能
			switch (choose) {
			case 1:
				// 我要订餐
				System.out.println("***我要订餐***");
				for (int j = 0; j < names.length; j++) {					
                   if(names[j] == null){  //找到第一个空位置，可以添加订单信息
                	   isAdd = true;  //置标志位，可以订餐
                	   System.out.print("请输入订餐人姓名：");
   					String name = input.next(); 
					// 显示供选择的菜品信息
					System.out.println("序号" + "\t" + "菜名"+"\t"+"单价");
					for (int i = 0; i < dishNames.length; i++) {
						String price = prices[i] + "元";
						String priaiseNum = (praiseNums[i]) > 0 ? praiseNums[i]
								+ "赞" : "";
						
						System.out.println((i + 1) + "\t" + dishNames[i] + "\t"	+price+"\t"+ priaiseNum);
					}
					// 用户点菜
					System.out.print("请选择您要点的菜品编号:");
					int chooseDish = input.nextInt();
					System.out.print("请选择您需要的份数:");
					int number = input.nextInt();
					String dishMeg =  dishNames[chooseDish - 1]
							+" "+ number + "份";
					double sumPrice = prices[chooseDish - 1] * number;
					//餐费满50元，免送餐费10元
					double deliCharge = (sumPrice>=50)?0:6;                   

					System.out.print("请输入送餐时间（送餐时间是10点至20点间整点送餐）:");
					int time = input.nextInt();
					while (time < 10 || time > 20) {
						System.out.print("您的输入有误，请输入10~20间的整数！");
						time = input.nextInt();
					}
					System.out.print("请输入送餐地址：");
					String address = input.next();
										
					//无需添加状态，默认是0，即已预定状态。
					System.out.println("订餐成功！");
					System.out.println("您订的是："+dishMeg);
					System.out.println("送餐时间："+time+"点");
					System.out.println("餐费："+sumPrice+"元，送餐费"+deliCharge+"元，总计："+(sumPrice+deliCharge)+"元。");
					
					//添加数据
					names[j] = name;
					dishMegs[j] = dishMeg;
					times[j] = time;
					addresses[j] = address;
					sumPrices[j] = sumPrice+deliCharge;
					
					break;					
                   }
				}
				if(!isAdd){
					System.out.println("对不起，您的餐袋已满！");
				}
				break;
			case 2:
				// 查看餐袋
				System.out.println("***查看餐袋***");
				System.out.println("序号\t订餐人\t餐品信息\t\t送餐日期\t送餐地址\t\t总金额\t订单状态");
				for(int i=0;i<names.length;i++){
					if(names[i]!=null){  
						String state = (states[i]==0)?"已预定":"已完成";
						String date = times[i]+"日";
						String sumPrice = sumPrices[i]+"元";
						System.out.println((i+1)+"\t"+names[i]+"\t"+dishMegs[i]+"\t"+date+"\t"+addresses[i]+"\t"+sumPrice+"\t"+state);
					}
				}
				break;
			case 3:
				// 签收定单
				System.out.println("***签收定单***");
				System.out.print("请选择要签收的订单序号：");
				int signOrderId = input.nextInt();
				for(int i=0;i<names.length;i++){
					//状态为已预定，序号为用户输入的订单序号：可签收
					//状态为已完成，序叼为用户输入胡订单序号：不可签收					
					if(names[i]!=null && states[i]==0 && signOrderId==i+1){
						states[i] = 1; //将状态值置为已完成
						System.out.println("订单签收成功！");
						isSignFind = true;
					}else if(names[i]!=null && states[i]==1 && signOrderId==i+1){
						System.out.println("您选择的订单已完成签收，不能再次签收！");
						isSignFind = true;
					}
				}
				//未找到的订单序号：不可签收
				if(!isSignFind){
					System.out.println("您选择的订单不存在！");
				}
				break;
			case 4:
				// 删除订单
				System.out.println("***删除订单***");
				System.out.print("请输入要删除的订单序号:");
				int delId = input.nextInt();
				for(int i=0;i<names.length;i++){
					//状态值为已完成  序号值为用户输入的序号：可删除
					//状态值为已预定  序号值为用户输入的序号：不可删除
					if(names[i]!=null && states[i]==1 && delId==i+1){	
						isDelFind = true;
						//执行删除操作:删除位置后的元素依次前移
						for(int j=delId-1;j<names.length-1;j++){
							names[j] = names[j+1];
							dishMegs[j] = dishMegs[j+1];
							times[j] = times[j+1];
							addresses[j] = addresses[j+1];
							states[j] = states[j+1];
						}
						//最后一位清空
						names[names.length-1] = null;
						dishMegs[names.length-1] = null;
						times[names.length-1] = 0;
						addresses[names.length-1] = null;
						states[names.length-1] = 0;
						
						System.out.println("删除订单成功！");
						break;
					}else if(names[i]!=null && states[i]==0 && delId==i+1){
						System.out.println("您选择的订单未签收，不能删除！");
						isDelFind = true;
						break;
					}
				}
				
				//未找到该序号的订单：不能删除
				if(!isDelFind){
					System.out.println("您要删除的订单不存在！");
				}							
				break;
			case 5:
				// 我要点赞
				System.out.println("***我要点赞***");
				// 显示菜品信息
				System.out.println("序号" + "\t" + "菜名"+"\t"+"单价");
				for (int i = 0; i < dishNames.length; i++) {
					String price = prices[i] + "元";
					String priaiseNum = (praiseNums[i]) > 0 ? praiseNums[i]
							+ "赞" : "";
					
					System.out.println((i + 1) + "\t" + dishNames[i] + "\t"	+price+"\t"+ priaiseNum);
				}
				System.out.print("请选择您要点赞的菜品序号：");
				int priaiseNum = input.nextInt();
				praiseNums[priaiseNum-1]++;  //赞数加1
				System.out.println("点赞成功！");
				break;
			case 6:
				// 退出系统
				isExit = true;
				break;
			default:
				//退出系统
				isExit = true;
				break;
			}
			if (!isExit) {
				System.out.print("输入0返回：");
				num = input.nextInt();
			} else {
				break;
			}
		} while (num == 0);
		System.out.println("谢谢使用，欢迎下次光临！");
	}
}
/**
 * 第一阶段：分析数据主体
	我要订餐 查看餐袋 删除订单 签收订单
	一组订单（订餐人 所定餐品信息 送菜时间 送餐地址 订单状态 总金额）
	多个数组
	
	我要点赞 （餐品）
	一组餐品（餐品名 单价 点赞数）
第二阶段：分析并完成整体框架
 循环（ do-while ) 
 循环操作：
	显示主菜单
	提示用户输入功能编号，并执行相应功能
	提示输入0返回
 循环条件：
	输入0

 分支（ switch ）

 根据用户输入功能编号，并执行相应的功能
第三阶段：分析并完成推出功能
	1、当现实主菜单之后，用户输入6或者1~6之外的数据
	2、执行完相应功能之后，提示输入0返回时，输入一个非零的数字
第四阶段：分析并完成订餐功能
	1、查找插入位置
	找要插入的位置，循环遍历订餐人第一个为空的位置
	如果找到了，则此位置就是要插入数据的位置
	没找到，则显示餐袋已满。

	2、执行添加数据操作
	a、显示所有可供选择的餐品信息
	   用户选择餐品编号 以及 份数
	b、输入订餐人姓名
	c、输入送餐时间（10~20点之间整点送餐）
	   当输入的信息有误时，重复输入
	d、输入送餐地址
	e、计算总金额
	   餐品总金额 = 餐品单价 * 份数
	f、送餐费：餐品总金额达到50元时，免6元餐费
	   订单总金额 =餐品总金额+送餐费
	3、显示订单信息
		所定餐品信息
		送餐时间
		送餐地址
		金额
	4、向数组中保存数据
第五阶段：分析并完成查看餐袋功能
	显示每条订单信息（遍历数组）
	序号 所订餐品信息 订餐人姓名 送餐时间 送餐地址 状态（已预定0 已完成1） 总金额
第六阶段：分析并完成签收订单功能
	要求用户输入一个签收的订单序号
	查找这条订单（循环遍历）
	1、找到，状态是已完成（已经签收完毕）：提示不能再次签收
	2、找到，状态时已预定（没有完成签收）：可以签收
	3、没找到：提示信息没有找到
第七阶段：分析并完成删除功能
	1、输入要删除的订单序号（从1开始）
	2、循环查找这条订单
		找到此订单，已签收：执行删除操作
		找到此订单，且未签收：提示信息
		未找到此订单：提示信息

	删除操作（循环移位）
	从要删除的元素后面一个开始，到数组最后一个元素依次向前移动一位
	最后一位清空
第八阶段：我要点赞
	1、显示供点赞的餐品列表
	2、输入点赞的餐品序号
	3、该序号的餐品点赞数加一
	4、显示
项目总结
	理解需求
	重难点突破
		1、数据主体
		2、整体框架
		3、删除功能
	注意细节
		标识位、跳转语句、数组的操作
	掌握调试技巧
	*/

package com.bswxb.vo;

public class ScoreVo {

	// 各党派的评价百分比、综合分数
	private double jiaren;
	private double baihe;
	private double tongchi;
	private double zhengjv;
	private double avg;
	private int num;

	public ScoreVo(double jiaren, double baihe, double tongchi, double zhengjv,
			double avg,int num) {

		this.jiaren = jiaren;
		this.baihe = baihe;
		this.tongchi = tongchi;
		this.zhengjv = zhengjv;
		this.avg = avg;
		this.num = num;
	}

	public double getJiaren() {
		return jiaren;
	}

	public void setJiaren(double jiaren) {
		this.jiaren = jiaren;
	}

	public double getBaihe() {
		return baihe;
	}

	public void setBaihe(double baihe) {
		this.baihe = baihe;
	}

	public double getTongchi() {
		return tongchi;
	}

	public void setTongchi(double tongchi) {
		this.tongchi = tongchi;
	}

	public double getZhengjv() {
		return zhengjv;
	}

	public void setZhengjv(double zhengjv) {
		this.zhengjv = zhengjv;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}

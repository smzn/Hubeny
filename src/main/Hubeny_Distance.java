package main;

import java.util.Scanner;

public class Hubeny_Distance {
	public static void main(String args[]) {
		Scanner stdin = new Scanner(System.in);
		double x1=140.08785502777778;//経度１
		double y1=36.10377477777778;//緯度１
		double x2=139.74475044444443;//経度２
		double y2=35.65502847222223;//緯度２
		double d;

		/*
		 * Hubeny_start(経度１, 緯度１, 経度２, 緯度２)で楕円上の距離ｄを返す
		 * ※引数は経度、緯度の順なので注意
		 */
		d = Hubeny_Distance_start(x1, y1, x2, y2);

		System.out.println("距離："+d);
	}

	public static double Hubeny_Distance_start(double x1, double y1, double x2, double y2){
		double d;//二点間距離
		double X1, Y1, X2, Y2;//各値のラジアン値
		double dx, dy;//X値、Y値の差
		double MuY;//緯度の平均値
		double W;
		double M;//子午線曲率半径
		double N;//卯酉線曲率半径
		//double E =0.00669437999014;//第一離心率eの二乗
		double E;
		double a=6378137.0;//長半径（赤道半径）
		double b=6356752.314140;//短半径（極半径）

		X1 = _toRadians(x1);
		Y1 = _toRadians(y1);
		X2 = _toRadians(x2);
		Y2 = _toRadians(y2);

		dx = X1-X2;
		dy = Y1-Y2;

		MuY = (Y1+Y2)/2;

		E = ((a*a)-(b*b))/(a*a);

		W = Math.sqrt( 1-(E*(Math.sin(MuY)*Math.sin(MuY))) );

		M = (a*(1-E)) / (W*W*W);

		N = a/W;

		d = Math.sqrt( ((dy*M)*(dy*M))+((dx*N*Math.cos(MuY))*(dx*N*Math.cos(MuY))) );

		return d;
	}
	/*
     * 角度をラジアンに変換する
     */
    private static double _toRadians(double deg)
    {
        return deg * Math.PI / 180.0;
    }

    /*
     * ラジアンを角度に変換する
     */
    private static double _toDegrees(double rad)
    {
        return rad * 180.0 / Math.PI;
    }
}



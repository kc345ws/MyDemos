#include<Windows.h>
#include<iostream>
#include <opencv2/core/core.hpp>  
#include <opencv2/highgui/highgui.hpp> 
#include<opencv2/imgproc.hpp>

#include<opencv2/opencv.hpp>
#include<opencv2/objdetect.hpp>

/*
Opencv�������ģ�飬coreģ��������Ĺ��ܣ�imgprocģ�����ͼ����
highguiģ�������дͼ�����Ƶ��һЩ��������ʹ����Щģ��֮ǰ����Ҫ����ͷ�ļ���*/

using namespace std;
using namespace cv;

int main() {
	Mat img = imread("Imgs/1.jpg", IMREAD_COLOR);
	imshow("����", img);
	waitKey(0);
}
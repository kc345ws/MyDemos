#include<Windows.h>
#include<iostream>
#include <opencv2/core/core.hpp>  
#include <opencv2/highgui/highgui.hpp> 
#include<opencv2/imgproc.hpp>

#include<opencv2/opencv.hpp>
#include<opencv2/objdetect.hpp>

/*
Opencv包含多个模块，core模块包含核心功能，imgproc模块包含图像处理，
highgui模块包含读写图像和视频的一些函数，在使用这些模块之前，需要包含头文件。*/

using namespace std;
using namespace cv;

int main() {
	Mat img = imread("Imgs/1.jpg", IMREAD_COLOR);
	imshow("测试", img);
	waitKey(0);
}
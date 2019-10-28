
// CGWORK0933.h: CGWORK0933 应用程序的主头文件
//
#pragma once

#ifndef __AFXWIN_H__
	#error "在包含此文件之前包含“stdafx.h”以生成 PCH 文件"
#endif

#include "resource.h"       // 主符号


// CCGWORK0933App:
// 有关此类的实现，请参阅 CGWORK0933.cpp
//

class CCGWORK0933App : public CWinApp
{
public:
	CCGWORK0933App() noexcept;


// 重写
public:
	virtual BOOL InitInstance();
	virtual int ExitInstance();

// 实现
	afx_msg void OnAppAbout();
	DECLARE_MESSAGE_MAP()
};

extern CCGWORK0933App theApp;


// CGWORK0933View.cpp: CCGWORK0933View 类的实现
//

#include "stdafx.h"
// SHARED_HANDLERS 可以在实现预览、缩略图和搜索筛选器句柄的
// ATL 项目中进行定义，并允许与该项目共享文档代码。
#ifndef SHARED_HANDLERS
#include "CGWORK0933.h"
#endif

#include "CGWORK0933Doc.h"
#include "CGWORK0933View.h"
#include "ChcTools.h"
#include <math.h>
//#include<list>


#ifdef _DEBUG
#define new DEBUG_NEW
#define PI 3.1415926
#endif

using namespace std;
/*---------------------生成代码------------------------*/
#pragma region 生成代码
// CCGWORK0933View

IMPLEMENT_DYNCREATE(CCGWORK0933View, CView)

BEGIN_MESSAGE_MAP(CCGWORK0933View, CView)
	// 标准打印命令
	ON_COMMAND(ID_FILE_PRINT, &CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, &CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, &CView::OnFilePrintPreview)
	ON_COMMAND(ID_DRAW_RECT, &CCGWORK0933View::OnDrawRect)
	ON_WM_LBUTTONDBLCLK()//消息和消息处理函数的映射
	ON_WM_LBUTTONDOWN()
	ON_WM_LBUTTONUP()
	ON_WM_MOUSEMOVE()
	ON_COMMAND(ID_DRAW_LINE, &CCGWORK0933View::OnDrawLine)
	ON_COMMAND(ID_DRAW_CIRCULAR, &CCGWORK0933View::OnDrawCircular)
	ON_COMMAND(ID_DRAW_SET_COLOR, &CCGWORK0933View::OnDrawSetColor)
	ON_COMMAND(ID_DRAW_POLYGON, &CCGWORK0933View::OnDrawPolygon)
	ON_COMMAND(ID_SET_POLYGON_COLOR, &CCGWORK0933View::OnSetPolygonColor)
	ON_COMMAND(ID_Invalidate, &CCGWORK0933View::OnInvalidate)
	ON_WM_KEYDOWN()
	ON_COMMAND(ID_DRAW_CUBE, &CCGWORK0933View::OnDrawCube)
//	ON_WM_CONTEXTMENU()
//ON_WM_SIZE()
ON_COMMAND(ID_RoateZ, &CCGWORK0933View::OnRoatez)
ON_COMMAND(ID_RoateX, &CCGWORK0933View::OnRoatex)
ON_COMMAND(ID_RoateY, &CCGWORK0933View::OnRoatey)
ON_COMMAND(ID_DRAW_BEZIER, &CCGWORK0933View::OnDrawBezier)
END_MESSAGE_MAP()

// CCGWORK0933View 构造/析构

CCGWORK0933View::CCGWORK0933View() noexcept
{
	// TODO: 在此处添加构造代码
	m_LButtonDown = false;//默认鼠标左键未按下
	m_DrawType = LINE;//默认直线
	m_isDraw = true;

	m_PenColor = RGB(0, 0, 0);
	m_Pen.CreatePen(PS_SOLID, 3, RGB(42, 67, 23));

	m_isDrawPoly = false;

	m_PolyCount = 0;
	m_RoateType = Roate_X;//默认绕X轴旋转
	m_PloyCpoints = list<CPoint>();
	//  cxClient = 0;
	//  cyClient = 0;



	/*-----------------正方体三维坐标------------------*/
	/*m_CubeThPoints[0] = ThPoint(0, 0, 0);
	m_CubeThPoints[1] = ThPoint(100, 0, 0);
	m_CubeThPoints[2] = ThPoint(0, 0, 100);
	m_CubeThPoints[3] = ThPoint(100, 0, 100);
	m_CubeThPoints[4] = ThPoint(0, 100, 0);
	m_CubeThPoints[5] = ThPoint(100, 100, 0);
	m_CubeThPoints[6] = ThPoint(0, 100, 100);
	m_CubeThPoints[7] = ThPoint(100, 100, 100);*/
	m_CubeThPoints[0] = ThPoint(0+200, 0 + 200, 0 + 200);
	m_CubeThPoints[1] = ThPoint(100 + 200, 0 + 200, 0 + 200);
	m_CubeThPoints[2] = ThPoint(0 + 200, 0 + 200, 100 + 200);
	m_CubeThPoints[3] = ThPoint(100 + 200, 0 + 200, 100 + 200);
	m_CubeThPoints[4] = ThPoint(0 + 200, 100 + 200, 0 + 200);
	m_CubeThPoints[5] = ThPoint(100 + 200, 100 + 200, 0 + 200);
	m_CubeThPoints[6] = ThPoint(0 + 200, 100 + 200, 100 + 200);
	m_CubeThPoints[7] = ThPoint(100 + 200, 100 + 200, 100 + 200);
	//m_CubeThPoints[4].x = 100;
	Perspective();//透视投影矩阵
	/*-----------------正方体三维坐标------------------*/
	

	/*----------Bezier曲线------------*/
	m_nCount = 0;//鼠标左键按下的次数
	nMethod = 1;//Bezier绘制方法初始为0 直接绘制法 1几何绘制 2分裂法

	/*----------Bezier曲线------------*/
	m_MenuType = 0;
}

CCGWORK0933View::~CCGWORK0933View()
{

}

BOOL CCGWORK0933View::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: 在此处通过修改
	//  CREATESTRUCT cs 来修改窗口类或样式

	return CView::PreCreateWindow(cs);
}

// CCGWORK0933View 绘图

void CCGWORK0933View::OnDraw(CDC* /*pDC*/)
{
	CCGWORK0933Doc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	if (!pDoc)
		return;


	CClientDC dc(this);

	
	/*CClientDC dc(this);


	dc.SelectObject(m_Pen);
	dc.LineTo(400, 500);
	for (int i = 100; i < 300; i++) {
		dc.SetPixel(i, i, m_PenColor);
	}*/
	;
	// TODO: 在此处为本机数据添加绘制代码
}


// CCGWORK0933View 打印

BOOL CCGWORK0933View::OnPreparePrinting(CPrintInfo* pInfo)
{
	// 默认准备
	return DoPreparePrinting(pInfo);
}

void CCGWORK0933View::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: 添加额外的打印前进行的初始化过程
}

void CCGWORK0933View::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: 添加打印后进行的清理过程
}


// CCGWORK0933View 诊断

#ifdef _DEBUG
void CCGWORK0933View::AssertValid() const
{
	CView::AssertValid();
}

void CCGWORK0933View::Dump(CDumpContext& dc) const
{
	CView::Dump(dc);
}

CCGWORK0933Doc* CCGWORK0933View::GetDocument() const // 非调试版本是内联的
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CCGWORK0933Doc)));
	return (CCGWORK0933Doc*)m_pDocument;
}
#endif //_DEBUG
#pragma endregion


/*---------------------鼠标代码------------------------*/
#pragma region 鼠标代码
//鼠标左键双击消息函数
void CCGWORK0933View::OnLButtonDblClk(UINT nFlags, CPoint point)
{
	// TODO: 在此添加消息处理程序代码和/或调用默认值
	CView::OnLButtonDblClk(nFlags, point);
}

//鼠标左键按下消息函数
void CCGWORK0933View::OnLButtonDown(UINT nFlags, CPoint point)
{
	// TODO: 在此添加消息处理程序代码和/或调用默认值
	/*if (m_isDraw || m_isDrawPoly) {
		DrawLButtonDown(nFlags, point);
	}*/
	DrawLButtonDown(nFlags, point);


	/*------------Bezier曲线绘制-------------*/
	if (m_MenuType == 3) {
		ptControlPts[m_nCount] = point;//保存鼠标左键按下的当前位置
		m_Newpoint = point;//存放画线的起始位置
		m_nCount = (++m_nCount)%(N + 1);//记录鼠标左键按下的次数，次数>=N+1时归零
	}
	/*------------Bezier曲线绘制-------------*/
	CView::OnLButtonDown(nFlags, point);
}

//鼠标左键抬起消息函数
void CCGWORK0933View::OnLButtonUp(UINT nFlags, CPoint point)
{
	// TODO: 在此添加消息处理程序代码和/或调用默认值
	/*
	我们发现在函数中已经添加了一句代码，这行代码是调用对应的父类的鼠标消息处理函数
	进行一些默认处理。我们所添加的代码都必须添加到该句代码之前，并且此句代码不能删除，
	否则将会出错。同时需要注意的是，Windows的鼠标消息发生的间隔是一秒钟，并不是所有的
	鼠标动作都会产生鼠标消息。假设你按鼠标左键的速度足够快，在一秒钟内可以按鼠标左键多
	次，则并不是每次按键都会产生鼠标消息，只有第一次按键以及后面按键与前一次按键的时间
	间隔在一秒钟以上的那些按键才会产生鼠标消息。
	*/
	/*if (m_isDraw || m_isDrawPoly) {
		DrawLButtonUp(nFlags, point);
	}*/
	DrawLButtonUp(nFlags, point);

	/*------------Bezier曲线----------*/
	if (m_MenuType == 3) {
		if (m_nCount == 0) {
			//m_nCount为0，即鼠标左键按下的次数为N+1的整数倍，则绘制曲线
			CClientDC dc(this);//设备环境
			CPen pen, *oldpen;
			pen.CreatePen(PS_SOLID, 1, RGB(255, 0, 0));
			oldpen = dc.SelectObject(&pen);
			DrawBezier(&dc, ptControlPts, N, ptPts, npoints);
			dc.SelectObject(oldpen);
		}
	}

	/*------------Bezier曲线----------*/
	CView::OnLButtonUp(nFlags, point);
}

//鼠标移动消息函数
void CCGWORK0933View::OnMouseMove(UINT nFlags, CPoint point)
{
	// TODO: 在此添加消息处理程序代码和/或调用默认值
	/*if (m_isDraw || m_isDrawPoly) {
		DrawMouseMove(nFlags, point);
	}*/
	DrawMouseMove(nFlags, point);

	/*-----------------Bezier曲线--------------------*/
	if (m_MenuType == 3) {
		if ((m_nCount > 0) && (m_nCount <= N)) {
			CClientDC dc(this);//设备环境
			dc.SetROP2(R2_NOT);
			dc.MoveTo((CPoint)ptControlPts[m_nCount - 1]);//擦除前面绘制的曲线
			dc.LineTo(m_Newpoint);
			dc.MoveTo((CPoint)ptControlPts[m_nCount - 1]);//从起始位置到当前位置
			dc.LineTo(point);
			m_Newpoint = point;//存放当前鼠标位置
		}
	}
	/*-----------------Bezier曲线--------------------*/
	CView::OnMouseMove(nFlags, point);
}


// 鼠标绘图时鼠标左键按下消息处理函数
void CCGWORK0933View::DrawLButtonDown(UINT nFlags, CPoint point)
{
	// TODO: 在此处添加实现代码.
	CClientDC *cdc = (CClientDC*)GetDC();
	cdc->SelectObject(m_Pen);

	if (m_isDraw) {
		//如果在绘制图形
		this->SetCapture();//捕获鼠标
		m_StartPoint = point;
		m_EndPoint = point;
		m_LButtonDown = true;
	}else if (m_isDrawPoly && m_PolyCount == 0) {
		//如果在绘制多边形，且是第一次绘制
		this->SetCapture();//捕获鼠标
		m_StartPoint = point;
		m_EndPoint = point;
		m_LButtonDown = true;
		m_PolyCount++;
		m_PloyCpoints.push_back(m_StartPoint);
	}
	else if (m_isDrawPoly && m_PolyCount != 0) {
		//如果在绘制多边形，且不是第一次绘制
		//m_EndPoint = point;
		m_LButtonDown = true;

		ChcTools chc;
		cdc->MoveTo(m_EndPoint);
		if (((point.x - m_StartPoint.x)*(point.x - m_StartPoint.x)
			+ (point.y - m_StartPoint.y)*(point.y - m_StartPoint.y)) <= 300.0) {
			chc.DDALine(cdc, m_EndPoint, m_StartPoint, m_PenColor);
			m_PolyCount = 0;


			/*---------------------------------------------*/
			CBitmap bitmap;
			bitmap.LoadBitmapW(IDB_SID);
			CDC bmp;
			bmp.CreateCompatibleDC(cdc);//创建一个兼容cdc的设备上下文
			bmp.SelectObject(&bitmap);//替换设备上下文资源

			//cdc->BitBlt(0, 0, 38,19, &bmp, 0, 0, SRCCOPY);//复制bmp到cdc
			
			//cdc->BitBlt(m_StartPoint.x, m_StartPoint.y, 10, 10, &bmp, 0, 0, SRCCOPY);
			//COLORREF color = RGB(234, 32, 34);
			
			CBrush cBrush(&bitmap);


			//cdc->FillRect(CRect(100, 200, 300, 400), &cBrush);

			
			/*CPoint cpoint[3];
			cpoint[0].x = 100;
			cpoint[0].y = 100;
			cpoint[1].x = 200;
			cpoint[1].y = 100;
			cpoint[2].x = 150;
			cpoint[2].y = 200;
			CRgn crgn;*/
			CRgn crgn;
			CPoint *cpoint = new CPoint[m_PloyCpoints.size()];
			int count = 0;
			for (auto item : m_PloyCpoints) {
				cpoint[count] = item;
				count++;
			}
			if (crgn.CreatePolygonRgn(cpoint, m_PloyCpoints.size(), ALTERNATE))
			{
				//cdc->MoveTo(cpoint[0]);
				cdc->FillRgn(&crgn, &cBrush);
				for (int i = 0; i < m_PloyCpoints.size()-1; i++) {
					cdc->MoveTo(cpoint[i]);
					cdc->LineTo(cpoint[i + 1]);
				}
				cdc->MoveTo(cpoint[m_PloyCpoints.size() - 1]);
				cdc->LineTo(cpoint[0]);
			}
			


			bitmap.DeleteObject();//释放资源对象
			//ReleaseDC(cdc);
			ReleaseDC(&bmp);//释放设备上下文
			m_PloyCpoints.clear();
		}
		else {
			chc.DDALine(cdc, m_EndPoint, point, m_PenColor);
			m_EndPoint = point;
			m_PolyCount++;
			m_PloyCpoints.push_back(m_EndPoint);
		}
		
	}

	ReleaseDC(cdc);
}


// 鼠标绘图时鼠标移动消息处理函数
void CCGWORK0933View::DrawMouseMove(UINT nFlags, CPoint point)
{
	// TODO: 在此处添加实现代码.
	//CClientDC cdc(this);
	//CDC *cdc = GetDC();
	CClientDC *cdc = (CClientDC*)GetDC();
	cdc->SelectObject(m_Pen);
	cdc->SetROP2(R2_NOTXORPEN);

	if (m_LButtonDown && m_isDraw) {
		//如果鼠标左键还在按下状态
		//cdc->SetROP2(R2_NOT);//设置绘图模式为R2_NOT模式
		//cdc->SetROP2(R2_NOTXORPEN);
		/*
		//重新绘制前一个鼠标移动消息处理函数绘制的直线段
		//因为绘图模式的原因，结果是擦除了该线段
		*/
		if (m_DrawType == LINE) {
			/*//如果是画直线
			CDC.MoveTo(m_StartPoint);
			CDC.LineTo(m_EndPoint);

			//绘制新的直线段
			CDC.MoveTo(m_StartPoint);
			CDC.LineTo(point);
			//保存新的直线段终点
			m_EndPoint = point;*/
			ChcTools chc;
			cdc->MoveTo(m_StartPoint);

			chc.DDALine(cdc, m_StartPoint, m_EndPoint, m_PenColor);

			cdc->MoveTo(m_StartPoint);
			chc.DDALine(cdc, m_StartPoint, point, m_PenColor);

			m_EndPoint = point;
		}
		else if (m_DrawType == RECTANGLE) {
			//画矩形
			ChcTools chc;


			cdc->MoveTo(m_StartPoint);

			chc.DrawRectangle(cdc, m_StartPoint, m_EndPoint, m_PenColor);

			cdc->MoveTo(m_StartPoint);
			chc.DrawRectangle(cdc, m_StartPoint, point, m_PenColor);


			//保存新的直线段终点
			m_EndPoint = point;
		}
		else if (m_DrawType == CIRCULAR) {
			//画矩形
			ChcTools chc;


			cdc->MoveTo(m_StartPoint);
			double oldR = sqrt(fabs((m_EndPoint.x - m_StartPoint.x)*(m_EndPoint.x - m_StartPoint.x)
			) + (m_EndPoint.y - m_StartPoint.y)*(m_EndPoint.y - m_StartPoint.y));
			chc.MidpointCircle(cdc, m_StartPoint, oldR, m_PenColor);

			double newR = sqrt(fabs((point.x - m_StartPoint.x)*(point.x - m_StartPoint.x)
			) + ((point.y - m_StartPoint.y)*(point.y - m_StartPoint.y)));
			cdc->MoveTo(m_StartPoint);
			chc.MidpointCircle(cdc, m_StartPoint, newR, m_PenColor);

			m_EndPoint = point;
		}
	}
	else if (m_LButtonDown && m_isDrawPoly) {
		/*ChcTools chc;
		cdc->MoveTo(m_StartPoint);

		chc.DDALine(cdc, m_StartPoint, m_EndPoint, m_PenColor);

		cdc->MoveTo(m_StartPoint);
		chc.DDALine(cdc, m_StartPoint, point, m_PenColor);

		m_EndPoint = point;*/
	}
	/*
		因为m_EndPoint中存放的一直是上次调用鼠标移动消息处理函数时鼠标光标所处的位置，
		所以绘制m_StartPoint和m_EndPoint之间的直线段时，该直线段已经存在了，因为绘图
		模式的关系，本次绘图就起到了将原来的线段擦除的功能。在m_StartPoint和point之间
		绘制直线段，此时point点是新的位置，所以原来视图区中不会有该直线段存在，则此时
		绘图实际在视图区中绘制了一条从m_StartPoint到point的直线段。最后将m_EndPoint赋
		值为point，保证下一次执行鼠标移动消息处理函数时可以正确的将本次执行时绘制的直
		线段擦除掉。*/
	ReleaseDC(cdc);
}


// 鼠标绘图时鼠标左键抬起消息处理函数
void CCGWORK0933View::DrawLButtonUp(UINT nFlags, CPoint point)
{
	// TODO: 在此处添加实现代码.
	m_LButtonDown = false;
	//m_isDraw = false;
	ReleaseCapture();//释放鼠标

}
#pragma endregion


/*---------------------图形绘制------------------------*/
#pragma region 图形绘制代码
// CCGWORK0933View 消息处理程序

//画直线
void CCGWORK0933View::OnDrawLine()
{
	// TODO: 在此添加命令处理程序代码
	m_DrawType = LINE;
	m_isDraw = true;
	m_isDrawPoly = false;
}

//选择此菜单项后，可利用鼠标在视图区绘制矩形； 
void CCGWORK0933View::OnDrawRect()
{
	// TODO: 在此添加命令处理程序代码
	m_DrawType = RECTANGLE;
	m_isDraw = true;
	m_isDrawPoly = false;
}

//
void CCGWORK0933View::OnDrawCircular()
{
	// TODO: 在此添加命令处理程序代码
	m_DrawType = CIRCULAR;
	m_isDraw = true;
	m_isDrawPoly = false;
}

//设置颜色
void CCGWORK0933View::OnDrawSetColor()
{
	// TODO: 在此添加命令处理程序代码
	COLORREF color = RGB(0, 0, 0);
	CColorDialog cdlg(color, CC_FULLOPEN | CC_RGBINIT); // 设置默认颜色

	if (cdlg.DoModal()) {
		color = cdlg.GetColor();
		m_Pen.DeleteObject();//删除上下文环境中的旧画笔
		m_Pen.CreatePen(PS_SOLID, 10, color);
		m_PenColor = color;
	}
}
#pragma endregion


/*---------------------区域填充------------------------*/
#pragma region 区域填充代码
//绘制多边形
void CCGWORK0933View::OnDrawPolygon()
{
	// TODO: 在此添加命令处理程序代码
	m_isDraw = false;
	m_isDrawPoly = true;
}

//设置多边形填充颜色
void CCGWORK0933View::OnSetPolygonColor()
{
	// TODO: 在此添加命令处理程序代码
	COLORREF color = RGB(0, 0, 0);
	CColorDialog cdlg(color, CC_FULLOPEN | CC_RGBINIT); // 设置默认颜色

	if (cdlg.DoModal()) {
		color = cdlg.GetColor();
		m_Pen.DeleteObject();//删除上下文环境中的旧画笔
		m_Pen.CreatePen(PS_SOLID, 10, color);
		m_PenColor = color;
	}
}
#pragma endregion

#pragma region 三维图形绘制
//清屏
void CCGWORK0933View::OnInvalidate()
{
	// TODO: 在此添加命令处理程序代码
	Invalidate(true);
}

//键盘按键按下时的消息
void CCGWORK0933View::OnKeyDown(UINT nChar, UINT nRepCnt, UINT nFlags)
{
	// TODO: 在此添加消息处理程序代码和/或调用默认值

	CView::OnKeyDown(nChar, nRepCnt, nFlags);

	/*
	currentx1 currentx2 currenty1 currenty2 矩形对角线坐标
	dx dy矩形移动位移量，初始值都为0
	if(nChar == VK_LEFT)//nchar按键标识符
	左键dx = -1;
	up dy = -1;
	....

	invilidate无效化窗口从而调用ondraw，使得画面再次重画
	*/

	double deltax = 5.0;
	double deltay = 5.0;
	//OnInvalidate();
	ClearScreen();
	if (nChar == VK_LEFT) {
		for (int i = 0; i < 8; i++) {
			//m_Cube2DPoints[i].x -= deltax;
			m_CubeThPoints[i].x -= deltax;
		}
	}
	else if (nChar == VK_RIGHT) {
		for (int i = 0; i < 8; i++) {
			//m_Cube2DPoints[i].x += deltax;
			m_CubeThPoints[i].x += deltax;
		}
	}
	else if (nChar == VK_UP) {
		for (int i = 0; i < 8; i++) {
			m_CubeThPoints[i].y -= deltax;
		}
	}
	else if (nChar == VK_DOWN) {
		for (int i = 0; i < 8; i++) {
			//m_Cube2DPoints[i].y += deltax;
			m_CubeThPoints[i].y += deltax;
		}
	}
	From3dTo2d();
	DrawCube();


}

//绘制立方体
void CCGWORK0933View::OnDrawCube()
{
	// TODO: 在此添加命令处理程序代码
	DrawCube();
}

//透视投影矩阵
void CCGWORK0933View::Perspective()
{
	// TODO: 在此处添加实现代码.
	double x0 = 0.5;//投影中心X坐标
	double y0 = 0.5;//投影中心Y坐标
	double d = 1;//z0 = -d
	/*
	实用中,常取z=0为投影平面，
	这时投影中心可取空间中任意一点(x0,y0,z0)。
	*/

	//第一列
	m_Proj_Matri[0][0] = 1;
	m_Proj_Matri[0][1] = 0;
	m_Proj_Matri[0][2] = x0 / d;
	m_Proj_Matri[0][3] = 0;

	//第二列
	m_Proj_Matri[1][0] = 0;
	m_Proj_Matri[1][1] = 1;
	m_Proj_Matri[1][2] = y0 / d;
	m_Proj_Matri[1][3] = 0;

	//第三列
	m_Proj_Matri[2][0] = 0;
	m_Proj_Matri[2][1] = 0;
	m_Proj_Matri[2][2] = 0;
	m_Proj_Matri[2][3] = 0;

	//第四列
	m_Proj_Matri[3][0] = 0;
	m_Proj_Matri[3][1] = 0;
	m_Proj_Matri[3][2] = 1.0 / d;
	m_Proj_Matri[3][3] = 1;


	From3dTo2d();
}

//将正方体顶点的三维坐标转换为二维坐标
void CCGWORK0933View::From3dTo2d()
{
	// TODO: 在此处添加实现代码.

	//第一个顶点
	m_Cube2DPoints[0].x =
		((m_CubeThPoints[0].x * m_Proj_Matri[0][0] +
			m_CubeThPoints[0].y * m_Proj_Matri[0][1] +
			m_CubeThPoints[0].z * m_Proj_Matri[0][2] +
			m_Proj_Matri[0][3]) + 0.5) / 1;
	m_Cube2DPoints[0].y =
		((m_CubeThPoints[0].x * m_Proj_Matri[1][0] +
			m_CubeThPoints[0].y * m_Proj_Matri[1][1] +
			m_CubeThPoints[0].z * m_Proj_Matri[1][2] +
			m_Proj_Matri[1][3]) + 0.5) / 1;

	//第二个顶点
	m_Cube2DPoints[1].x =
		((m_CubeThPoints[1].x * m_Proj_Matri[0][0] +
			m_CubeThPoints[1].y * m_Proj_Matri[0][1] +
			m_CubeThPoints[1].z * m_Proj_Matri[0][2] +
			m_Proj_Matri[0][3]) + 0.5) / 1;
	m_Cube2DPoints[1].y =
		((m_CubeThPoints[1].x * m_Proj_Matri[1][0] +
			m_CubeThPoints[1].y * m_Proj_Matri[1][1] +
			m_CubeThPoints[1].z * m_Proj_Matri[1][2] +
			m_Proj_Matri[1][3]) + 0.5) / 1;

	//第三个顶点
	m_Cube2DPoints[2].x =
		((m_CubeThPoints[2].x * m_Proj_Matri[0][0] +
			m_CubeThPoints[2].y * m_Proj_Matri[0][1] +
			m_CubeThPoints[2].z * m_Proj_Matri[0][2] +
			m_Proj_Matri[0][3]) + 0.5) / 1;
	m_Cube2DPoints[2].y =
		((m_CubeThPoints[2].x * m_Proj_Matri[1][0] +
			m_CubeThPoints[2].y * m_Proj_Matri[1][1] +
			m_CubeThPoints[2].z * m_Proj_Matri[1][2] +
			m_Proj_Matri[1][3]) + 0.5) / 1;

	//第四个顶点
	m_Cube2DPoints[3].x =
		((m_CubeThPoints[3].x * m_Proj_Matri[0][0] +
			m_CubeThPoints[3].y * m_Proj_Matri[0][1] +
			m_CubeThPoints[3].z * m_Proj_Matri[0][2] +
			m_Proj_Matri[0][3] + 0.5)) / 1;
	m_Cube2DPoints[3].y =
		((m_CubeThPoints[3].x * m_Proj_Matri[1][0] +
			m_CubeThPoints[3].y * m_Proj_Matri[1][1] +
			m_CubeThPoints[3].z * m_Proj_Matri[1][2] +
			m_Proj_Matri[1][3]) + 0.5) / 1;

	//第五个顶点
	m_Cube2DPoints[4].x =
		((m_CubeThPoints[4].x * m_Proj_Matri[0][0] +
			m_CubeThPoints[4].y * m_Proj_Matri[0][1] +
			m_CubeThPoints[4].z * m_Proj_Matri[0][2] +
			m_Proj_Matri[0][3]) + 0.5) / 1;
	m_Cube2DPoints[4].y =
		((m_CubeThPoints[4].x * m_Proj_Matri[1][0] +
			m_CubeThPoints[4].y * m_Proj_Matri[1][1] +
			m_CubeThPoints[4].z * m_Proj_Matri[1][2] +
			m_Proj_Matri[1][3]) + 0.5) / 1;

	//第六个顶点
	m_Cube2DPoints[5].x =
		((m_CubeThPoints[5].x * m_Proj_Matri[0][0] +
			m_CubeThPoints[5].y * m_Proj_Matri[0][1] +
			m_CubeThPoints[5].z * m_Proj_Matri[0][2] +
			m_Proj_Matri[0][3]) + 0.5) / 1;
	m_Cube2DPoints[5].y =
		((m_CubeThPoints[5].x * m_Proj_Matri[1][0] +
			m_CubeThPoints[5].y * m_Proj_Matri[1][1] +
			m_CubeThPoints[5].z * m_Proj_Matri[1][2] +
			m_Proj_Matri[1][3]) + 0.5) / 1;

	//第七个顶点
	m_Cube2DPoints[6].x =
		((m_CubeThPoints[6].x * m_Proj_Matri[0][0] +
			m_CubeThPoints[6].y * m_Proj_Matri[0][1] +
			m_CubeThPoints[6].z * m_Proj_Matri[0][2] +
			m_Proj_Matri[0][3]) + 0.5) / 1;
	m_Cube2DPoints[6].y =
		((m_CubeThPoints[6].x * m_Proj_Matri[1][0] +
			m_CubeThPoints[6].y * m_Proj_Matri[1][1] +
			m_CubeThPoints[6].z * m_Proj_Matri[1][2] +
			m_Proj_Matri[1][3]) + 0.5) / 1;

	//第八个顶点
	m_Cube2DPoints[7].x =
		((m_CubeThPoints[7].x * m_Proj_Matri[0][0] +
			m_CubeThPoints[7].y * m_Proj_Matri[0][1] +
			m_CubeThPoints[7].z * m_Proj_Matri[0][2] +
			m_Proj_Matri[0][3]) + 0.5) / 1;
	m_Cube2DPoints[7].y =
		((m_CubeThPoints[7].x * m_Proj_Matri[1][0] +
			m_CubeThPoints[7].y * m_Proj_Matri[1][1] +
			m_CubeThPoints[7].z * m_Proj_Matri[1][2] +
			m_Proj_Matri[1][3]) + 0.5) / 1;
}


//画矩形
void CCGWORK0933View::DrawRect(CPoint p1, CPoint p2, CPoint p3, CPoint p4, bool isfill) {
	CClientDC dc(this);
	dc.MoveTo(p1);
	dc.LineTo(p2);
	dc.LineTo(p3);
	dc.LineTo(p4);
	dc.LineTo(p1);

	if (isfill) {
		CRgn crgn;
		//CPoint *cpoint = new CPoint[4];
		CPoint cpoint[4];
		cpoint[0] = p1;
		cpoint[1] = p2;
		cpoint[2] = p3;
		cpoint[3] = p4;
		Fill(cpoint);
	}
	/*CBrush cBrush(RGB(234, 45, 23));
	if (crgn.CreatePolygonRgn(cpoint, 4, ALTERNATE))
	{
		dc.MoveTo(cpoint[0]);
		dc.FillRgn(&crgn, &cBrush);
		for (int i = 0; i < 4 - 1; i++) {
			dc.MoveTo(cpoint[i]);
			dc.LineTo(cpoint[i + 1]);
		}
		dc.MoveTo(cpoint[4 - 1]);
		dc.LineTo(cpoint[0]);
	}*/
}

void CCGWORK0933View::Fill(CPoint cpoints[]) {
	CClientDC dc(this);
	CRgn crgn;

	//srand(time(NULL)); //为rand函数提供种子
	//printf("%d\n", rand() % 10); //输出一个随机数，范围为0-9
	//printf("%d\n", rand() % 10 + 1); //输出一个随机数，范围为1-10
	static default_random_engine e; //随机数引擎类
	static uniform_int_distribution<unsigned> u(0, 255);//0-255
	CBrush cBrush(RGB(u(e), u(e), u(e)));
	if (crgn.CreatePolygonRgn(cpoints, 4, ALTERNATE))
	{
		dc.MoveTo(cpoints[0]);
		dc.FillRgn(&crgn, &cBrush);
		for (int i = 0; i < 4 - 1; i++) {
			dc.MoveTo(cpoints[i]);
			dc.LineTo(cpoints[i + 1]);
		}
		dc.MoveTo(cpoints[4 - 1]);
		dc.LineTo(cpoints[0]);
	}
}

//画立方体
void CCGWORK0933View::DrawCube() {
	DrawRect(m_Cube2DPoints[1 - 1], m_Cube2DPoints[2 - 1], m_Cube2DPoints[6 - 1], m_Cube2DPoints[5 - 1]);
	DrawRect(m_Cube2DPoints[2 - 1], m_Cube2DPoints[4 - 1], m_Cube2DPoints[8 - 1], m_Cube2DPoints[6 - 1]);
	DrawRect(m_Cube2DPoints[4 - 1], m_Cube2DPoints[8 - 1], m_Cube2DPoints[7 - 1], m_Cube2DPoints[3 - 1]);
	DrawRect(m_Cube2DPoints[1 - 1], m_Cube2DPoints[3 - 1], m_Cube2DPoints[7 - 1], m_Cube2DPoints[5 - 1]);
	DrawRect(m_Cube2DPoints[5 - 1], m_Cube2DPoints[6 - 1], m_Cube2DPoints[8 - 1], m_Cube2DPoints[7 - 1]);
	DrawRect(m_Cube2DPoints[1 - 1], m_Cube2DPoints[2 - 1], m_Cube2DPoints[4 - 1], m_Cube2DPoints[3 - 1]);

	/*重新绘制*/
	DrawRect(m_Cube2DPoints[1 - 1], m_Cube2DPoints[2 - 1], m_Cube2DPoints[6 - 1], m_Cube2DPoints[5 - 1], false);
	DrawRect(m_Cube2DPoints[2 - 1], m_Cube2DPoints[4 - 1], m_Cube2DPoints[8 - 1], m_Cube2DPoints[6 - 1], false);
	DrawRect(m_Cube2DPoints[4 - 1], m_Cube2DPoints[8 - 1], m_Cube2DPoints[7 - 1], m_Cube2DPoints[3 - 1], false);
	DrawRect(m_Cube2DPoints[1 - 1], m_Cube2DPoints[3 - 1], m_Cube2DPoints[7 - 1], m_Cube2DPoints[5 - 1], false);
	DrawRect(m_Cube2DPoints[5 - 1], m_Cube2DPoints[6 - 1], m_Cube2DPoints[8 - 1], m_Cube2DPoints[7 - 1], false);
	DrawRect(m_Cube2DPoints[1 - 1], m_Cube2DPoints[2 - 1], m_Cube2DPoints[4 - 1], m_Cube2DPoints[3 - 1], false);
}

void CCGWORK0933View::ClearScreen()
{
	// TODO: 在此处添加实现代码.
	CClientDC dc(this);
	CRect window;
	GetClientRect(window);
	//SelectStockObject只能把有限的几种对象选入设备环境，
	//而SelectObject是可以把任意GDI对象选入设备环境的啊
	dc.SelectStockObject(WHITE_PEN);
	dc.SelectStockObject(WHITE_BRUSH);
	dc.Rectangle(window);
}





BOOL CCGWORK0933View::PreTranslateMessage(MSG* pMsg)
{
	// TODO: 在此添加专用代码和/或调用基类
	if (WM_KEYFIRST <= pMsg->message && pMsg->message <= WM_KEYLAST) {
		//确定是键盘事件
		double Alpha = 5;
		Alpha *= PI / 180;
		double c = cos(Alpha);
		double s = sin(Alpha);
		double reversec = cos(-1 * Alpha);//反向旋转
		double reverses = sin(-1 * Alpha);
		double x;
		double y;
		double z;
		//旋转3D坐标下的立方体
		if (pMsg->lParam == 1966081) {//A
			//Z轴正向旋转
			if (m_RoateType == Roate_Z) {
				for (int i = 0; i < 8; i++) {
					x = m_CubeThPoints[i].x;
					y = m_CubeThPoints[i].y;
					m_CubeThPoints[i].x = x * c - y * s;
				}
				for (int i = 0; i < 8; i++) {
					x = m_CubeThPoints[i].x;
					y = m_CubeThPoints[i].y;
					m_CubeThPoints[i].y = x * s + y * c;
				}
				OnRoatez();
			}

			//X轴正向旋转
			else if (m_RoateType == Roate_X) {
				for (int i = 0; i < 8; i++) {//第二列
					y = m_CubeThPoints[i].y;
					z = m_CubeThPoints[i].z;
					m_CubeThPoints[i].y = y * c - z * s;
				}
				for (int i = 0; i < 8; i++) {//第三列
					y = m_CubeThPoints[i].y;
					z = m_CubeThPoints[i].z;
					m_CubeThPoints[i].z = y * s + z * c;
				}
				OnRoatex();
			}

			//Y轴正向旋转
			else if (m_RoateType == Roate_Y) {
				for (int i = 0; i < 8; i++) {//第一列
					x = m_CubeThPoints[i].x;
					z = m_CubeThPoints[i].z;
					m_CubeThPoints[i].x = x * c + z * s;
				}
				for (int i = 0; i < 8; i++) {//第三列
					x = m_CubeThPoints[i].x;
					z = m_CubeThPoints[i].z;
					m_CubeThPoints[i].z = z * c - x * s;
				}
				OnRoatey();
			}
		}

		//反向旋转
		else if (pMsg->lParam == 2490369) {//L
			if (m_RoateType == Roate_Z) {
				for (int i = 0; i < 8; i++) {
					x = m_CubeThPoints[i].x;
					y = m_CubeThPoints[i].y;
					m_CubeThPoints[i].x = x * reversec - y * reverses;
				}
				for (int i = 0; i < 8; i++) {
					x = m_CubeThPoints[i].x;
					y = m_CubeThPoints[i].y;
					m_CubeThPoints[i].y = x * reverses + y * reversec;
				}
				OnRoatez();
			}
			//X轴反向旋转
			else if (m_RoateType == Roate_X) {
				for (int i = 0; i < 8; i++) {//第二列
					y = m_CubeThPoints[i].y;
					z = m_CubeThPoints[i].z;
					m_CubeThPoints[i].y = y * reversec - z * reverses;
				}
				for (int i = 0; i < 8; i++) {//第三列
					y = m_CubeThPoints[i].y;
					z = m_CubeThPoints[i].z;
					m_CubeThPoints[i].z = y * reverses + z * reversec;
				}
				OnRoatex();
			}

			//Y轴反向旋转
			else if (m_RoateType == Roate_Y) {
				for (int i = 0; i < 8; i++) {//第一列
					x = m_CubeThPoints[i].x;
					z = m_CubeThPoints[i].z;
					m_CubeThPoints[i].x = x * reversec + z * reverses;
				}
				for (int i = 0; i < 8; i++) {//第三列
					x = m_CubeThPoints[i].x;
					z = m_CubeThPoints[i].z;
					m_CubeThPoints[i].z = z * reversec - x * reverses;
				}
				OnRoatey();
			}
		}
	}

	return CView::PreTranslateMessage(pMsg);
}

//立方体绕Z轴旋转变换矩阵
void CCGWORK0933View::OnRoatez()
{
	ClearScreen();
	m_RoateType = Roate_Z;
	// TODO: 在此添加命令处理程序代码
	/*double L = 2 / sqrt(3);
	double Alpha = 20;
	Alpha *= PI / 180;
	double c = cos(Alpha);
	double s = sin(Alpha);

	//第一列
	m_Proj_Matri[0][0] = 1;
	m_Proj_Matri[0][1] = 0;
	m_Proj_Matri[0][2] = L * c;
	m_Proj_Matri[0][3] = 0;

	//第二列
	m_Proj_Matri[1][0] = 0;
	m_Proj_Matri[1][1] = 1;
	m_Proj_Matri[1][2] = L * s;
	m_Proj_Matri[1][3] = 0;

	//第三列
	m_Proj_Matri[2][0] = 0;
	m_Proj_Matri[2][1] = 0;
	m_Proj_Matri[2][2] = 0;
	m_Proj_Matri[2][3] = 0;

	//第四列
	m_Proj_Matri[3][0] = 0;
	m_Proj_Matri[3][1] = 0;
	m_Proj_Matri[3][2] = 0;
	m_Proj_Matri[3][3] = 1;

	Perspective();
	From3dTo2d();
	DrawCube();*/

	double Alpha = 5;
	Alpha *= PI / 180;
	double c = cos(Alpha);
	double s = sin(Alpha);

	//第一列
	m_Proj_Matri[0][0] = c;
	m_Proj_Matri[0][1] = -1 * s;
	m_Proj_Matri[0][2] = 0;
	m_Proj_Matri[0][3] = 0;

	//第二列
	m_Proj_Matri[1][0] = s;
	m_Proj_Matri[1][1] = c;
	m_Proj_Matri[1][2] = 0;
	m_Proj_Matri[1][3] = 0;

	//第三列
	m_Proj_Matri[2][0] = 0;
	m_Proj_Matri[2][1] = 0;
	m_Proj_Matri[2][2] = 1;
	m_Proj_Matri[2][3] = 0;

	//第四列
	m_Proj_Matri[3][0] = 0;
	m_Proj_Matri[3][1] = 0;
	m_Proj_Matri[3][2] = 0;
	m_Proj_Matri[3][3] = 1;

	Perspective();
	From3dTo2d();
	DrawCube();
}
//绕X轴旋转
void CCGWORK0933View::OnRoatex()
{
	// TODO: 在此添加命令处理程序代码
	ClearScreen();
	m_RoateType = Roate_X;

	double Alpha = 5;
	Alpha *= PI / 180;
	double c = cos(Alpha);
	double s = sin(Alpha);

	//第一列
	m_Proj_Matri[0][0] = 1;
	m_Proj_Matri[0][1] = 0;
	m_Proj_Matri[0][2] = 0;
	m_Proj_Matri[0][3] = 0;

	//第二列
	m_Proj_Matri[1][0] = 0;
	m_Proj_Matri[1][1] = c;
	m_Proj_Matri[1][2] = -1 * s;
	m_Proj_Matri[1][3] = 0;

	//第三列
	m_Proj_Matri[2][0] = 0;
	m_Proj_Matri[2][1] = s;
	m_Proj_Matri[2][2] = c;
	m_Proj_Matri[2][3] = 0;

	//第四列
	m_Proj_Matri[3][0] = 0;
	m_Proj_Matri[3][1] = 0;
	m_Proj_Matri[3][2] = 0;
	m_Proj_Matri[3][3] = 1;

	Perspective();
	From3dTo2d();
	DrawCube();
}

//绕Y轴旋转
void CCGWORK0933View::OnRoatey()
{
	// TODO: 在此添加命令处理程序代码
	ClearScreen();
	m_RoateType = Roate_Y;

	double Alpha = 5;
	Alpha *= PI / 180;
	double c = cos(Alpha);
	double s = sin(Alpha);

	//第一列
	m_Proj_Matri[0][0] = c;
	m_Proj_Matri[0][1] = 0;
	m_Proj_Matri[0][2] = s;
	m_Proj_Matri[0][3] = 0;

	//第二列
	m_Proj_Matri[1][0] = 0;
	m_Proj_Matri[1][1] = 1;
	m_Proj_Matri[1][2] = 0;
	m_Proj_Matri[1][3] = 0;

	//第三列
	m_Proj_Matri[2][0] = -1 * s;
	m_Proj_Matri[2][1] = 0;
	m_Proj_Matri[2][2] = c;
	m_Proj_Matri[2][3] = 0;

	//第四列
	m_Proj_Matri[3][0] = 0;
	m_Proj_Matri[3][1] = 0;
	m_Proj_Matri[3][2] = 0;
	m_Proj_Matri[3][3] = 1;

	Perspective();
	From3dTo2d();
	DrawCube();
}
#pragma endregion

#pragma region 曲线绘制
void CCGWORK0933View::OnDrawBezier()
{
	// TODO: 在此添加命令处理程序代码
	m_isDraw = false;
	m_isDrawPoly = false;
	m_MenuType = 3;
	//CClientDC dc(this);
	//DrawBezier(&dc, ptControlPts, N, ptPts, npoints);
}

//输入参数P为控制点坐标，控制点个数为n+1
void CCGWORK0933View::bezier_to_points(Point P[], int n, Point pts[], int npoints)
{
	double t = 0, delt;
	int i;
	delt = 1.0 / (double)npoints;//将参数t的变化区间进行npoints等分
	switch (nMethod) {
	case 0:
		for (int i = 0; i < npoints; i++, t += delt) {
			pts[i] = Bezier(P, n, t);
		}
		break;

	case 1:
		for (i = 0; i <= npoints; i++, t += delt) {
			pts[i] = decas(P, n, t);
		}
		break;
	}
}

//计算Bezier各点坐标
Point CCGWORK0933View::Bezier(Point P[], int n, double t)
{
	Point ret = Point(0, 0);
	double temp;
	for (int i = 0; i <= n; i++) {
		temp = Bernstenin(i, n, t);
		ret += P[i] * temp;
	}
	return ret;
}

//计算伯恩斯坦基函数
double CCGWORK0933View::Bernstenin(int i, int n, double t)
{
	return Permutation(n, i) / Permutation(i, i)*pow((1 - t), n - i);
}

long CCGWORK0933View::Permutation(int n, int i)
{
	long ret = 1;
	if (n >= i) {
		for (int j = n; j > n - i; j--) {
			ret *= j;
		}
	}
	return ret;
}

Point CCGWORK0933View::decas(Point P[], int n, double t)
{
	int m, i;
	Point *R, *Q, p0;
	R = new Point[n + 1];
	Q = new Point[n + 1];
	for (i = 0; i <= n; i++) {
		R[i] = P[i];
	}
	for (m = n; m > 0; m--) {
		for (i = 0; i <= m - 1; i++) {
			Q[i] = R[i] + (R[i + 1] - R[i])*t;
		}
		for (i = 0; i <= m - 1; i++) {
			R[i] = Q[i];
		}
	}
	p0 = R[0];
	delete R;
	delete Q;
	return (p0);
}

//分裂华计算Bezier坐标
void CCGWORK0933View::new_split_Bezier(CDC * pDC, Point P[])
{
	Point R[N + 1], Q[N + 1];
	int i, j;
	const double epsilon = 1;
	if (maxdistance(P) < epsilon) {
		pDC->MoveTo((CPoint)P[0]);
		pDC->LineTo((CPoint)P[N]);
	}
	else {
		for (i = 0; i <= N; i++) {
			R[i] = P[i];
		}
		for (i = 0; i <= N; i++) {
			Q[i] = R[0];
			new_split_Bezier(pDC, Q);
			new_split_Bezier(pDC, R);
		}
	}
}

double CCGWORK0933View::maxdistance(Point P[])
{
	double s, h, hmax = 0;
	for (int i = 0; i < N - 1; i++) {
		s = ((P[0].x - P[i + 1].x)*(P[0].y + P[i + 1].y))
			+ (P[i + 1].x - P[N].x)*(P[i + 1].y + P[N].y)
			+ (P[N].x - P[0].x)*(P[N].y + P[0].y);
		double distance = sqrt((P[0].x - P[N].x)*(P[0].x - P[N].x)
			+ (P[0].y - P[N].y)*(P[0].y - P[N].y));

		h = fabs(s / distance);
		if (hmax < h) {
			hmax = h;
		}
	}
	return hmax;
}

void CCGWORK0933View::DrawBezier(CDC * pdc, Point P[], int n, Point pts[], int npoints)
{
	int i;
	switch (nMethod) {
	case 0:
		break;
	case 1:
		bezier_to_points(P, N, pts, npoints);//
		pdc->MoveTo((CPoint)pts[0]);
		for (i = 1; i <= npoints; i++) {
			pdc->LineTo((CPoint)pts[i]);
		}
		break;
	case 2:
		new_split_Bezier(pdc, P);
		break;
	}
}
#pragma endregion



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
ON_WM_SIZE()
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
	m_PloyCpoints = list<CPoint>();
	cxClient = 0;
	cyClient = 0;

	

	/*-----------------正方体三维坐标------------------*/
	m_CubeThPoints[0] = ThPoint(0, 0, 0);
	m_CubeThPoints[1] = ThPoint(100, 0, 0);
	m_CubeThPoints[2] = ThPoint(0, 0, 100);
	m_CubeThPoints[3] = ThPoint(100, 0, 100);
	m_CubeThPoints[4] = ThPoint(0, 100, 0);
	m_CubeThPoints[5] = ThPoint(100, 100, 0);
	m_CubeThPoints[6] = ThPoint(0, 100, 100);
	m_CubeThPoints[7] = ThPoint(100, 100, 100);
	
	//m_CubeThPoints[4].x = 100;
	/*-----------------正方体三维坐标------------------*/
	Perspective();//透视投影矩阵
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


//清屏
void CCGWORK0933View::OnInvalidate()
{
	// TODO: 在此添加命令处理程序代码
	Invalidate(true);
}








/*
void CCGWORK0933View::Fill(CDC*& pDC, int x, int y, COLORREF& oldColor, COLORREF& newColor)
{
	// TODO: 在此处添加实现代码.
	stack<Seed> sp;
	PolyGon

	int xl, xr;

	bool spanNeedfill;

	Seed pt;

	pt.x = x; pt.y = y;

	sp.push(pt);

	while (!sp.empty())

	{

		pt = sp.top(); sp.pop();

		y = pt.y; x = pt.x;

		while (pDC->GetPixel(x, y) == oldColor)//向右填充

		{

			pDC->SetPixel(x, y, newColor);

			x++;

		}

		xr = x - 1; x = pt.x - 1;

		while (pDC->GetPixel(x, y) == oldColor)//向左填充

		{

			pDC->SetPixel(x, y, newColor);

			x--;

		}

		xl = x + 1;

		//处理上面一条扫描线

		x = xl; y = y + 1;

		while (x <= xr)

		{

			spanNeedfill = false;

			while (pDC->GetPixel(x, y) == oldColor)

			{

				spanNeedfill = true;

				x++;

			}

			if (spanNeedfill)

			{

				pt.x = x - 1; pt.y = y;

				sp.push(pt);

				spanNeedfill = false;

			}

			while ((pDC->GetPixel(x, y) != oldColor) && x <= xr) x++;

		}



		//处理下面一条扫描线

		x = xl; y = y - 2;

		while (x <= xr)

		{

			spanNeedfill = false;

			while (pDC->GetPixel(x, y) == oldColor)

			{

				spanNeedfill = true;

				x++;

			}

			if (spanNeedfill)

			{

				pt.x = x - 1; pt.y = y;

				sp.push(pt);

				spanNeedfill = false;

			}

			while ((pDC->GetPixel(x, y) != oldColor) && x <= xr) x++;

		}

	}
}
*/


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
	if (nChar == VK_LEFT) {

	}
	else if (nChar == VK_RIGHT) {

	}
	else if (nChar == VK_UP) {

	}
	else if (nChar == VK_DOWN) {

	}

}

//绘制立方体
void CCGWORK0933View::OnDrawCube()
{
	// TODO: 在此添加命令处理程序代码
	DrawCube();
	/*CClientDC *cdc = (CClientDC*)GetDC();
	//cdc->SetViewportOrg()
	cdc->SetViewportOrg(cxClient / 2, cyClient / 2);
	cdc->MoveTo(-cxClient / 2, 0);
	cdc->LineTo(cxClient / 2, 0);
	cdc->MoveTo(0, -cyClient / 2);
	cdc->LineTo(0, cyClient / 2);
	


	ReleaseDC(cdc);*/
}


//void CCGWORK0933View::OnContextMenu(CWnd* /*pWnd*/, CPoint /*point*/)
//{
//	// TODO: 在此处添加消息处理程序代码
//}

//获取屏幕大小
void CCGWORK0933View::OnSize(UINT nType, int cx, int cy)
{
	CView::OnSize(nType, cx, cy);

	// TODO: 在此处添加消息处理程序代码
	cxClient = cx;
	cyClient = cy;

	ShadowTrans(-45);


}

//立方体数据结构 数组[8] 结构体x,y,z
//进行投影变换，变为二维坐标
//正方体透视投影
void CCGWORK0933View::ShadowTrans(int degree)
{
	// TODO: 在此处添加实现代码.

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
	m_Proj_Matri[0][2] = x0/d;
	m_Proj_Matri[0][3] = 0;

	m_Proj_Matri[1][0] = 0;
	m_Proj_Matri[1][1] = 1;
	m_Proj_Matri[1][2] = y0/d;
	m_Proj_Matri[1][3] = 0;

	m_Proj_Matri[2][0] = 0;
	m_Proj_Matri[2][1] = 0;
	m_Proj_Matri[2][2] = 0;
	m_Proj_Matri[2][3] = 0;

	m_Proj_Matri[3][0] = 0;
	m_Proj_Matri[3][1] = 0;
	m_Proj_Matri[3][2] = 1.0/d;
	//m_Proj_Matri[3][3] = 0;

	m_Proj_Matri[3][3] = 1;


	From3dTo2d();
}

//将正方体顶点的三维坐标转换为二维坐标
void CCGWORK0933View::From3dTo2d()
{
	// TODO: 在此处添加实现代码.

	//第一个顶点
	m_Cube2DPoints[0].x = 
		m_CubeThPoints[0].x * m_Proj_Matri[0][0] +
		m_CubeThPoints[0].y * m_Proj_Matri[0][1] + 
		m_CubeThPoints[0].z * m_Proj_Matri[0][2] + 
		m_Proj_Matri[0][3];
	m_Cube2DPoints[0].y =
		m_CubeThPoints[0].x * m_Proj_Matri[1][0] +
		m_CubeThPoints[0].y * m_Proj_Matri[1][1] +
		m_CubeThPoints[0].z * m_Proj_Matri[1][2] +
		m_Proj_Matri[1][3];

	//第二个顶点
	m_Cube2DPoints[1].x = 
		m_CubeThPoints[1].x * m_Proj_Matri[0][0] +
		m_CubeThPoints[1].y * m_Proj_Matri[0][1] +
		m_CubeThPoints[1].z * m_Proj_Matri[0][2] +
		m_Proj_Matri[0][3];
	m_Cube2DPoints[1].y =
		m_CubeThPoints[1].x * m_Proj_Matri[1][0] +
		m_CubeThPoints[1].y * m_Proj_Matri[1][1] +
		m_CubeThPoints[1].z * m_Proj_Matri[1][2] +
		m_Proj_Matri[1][3];

	//第三个顶点
	m_Cube2DPoints[2].x =
		m_CubeThPoints[2].x * m_Proj_Matri[0][0] +
		m_CubeThPoints[2].y * m_Proj_Matri[0][1] +
		m_CubeThPoints[2].z * m_Proj_Matri[0][2] +
		m_Proj_Matri[0][3];
	m_Cube2DPoints[2].y =
		m_CubeThPoints[2].x * m_Proj_Matri[1][0] +
		m_CubeThPoints[2].y * m_Proj_Matri[1][1] +
		m_CubeThPoints[2].z * m_Proj_Matri[1][2] +
		m_Proj_Matri[1][3];

	//第四个顶点
	m_Cube2DPoints[3].x =
		m_CubeThPoints[3].x * m_Proj_Matri[0][0] +
		m_CubeThPoints[3].y * m_Proj_Matri[0][1] +
		m_CubeThPoints[3].z * m_Proj_Matri[0][2] +
		m_Proj_Matri[0][3];
	m_Cube2DPoints[3].y =
		m_CubeThPoints[3].x * m_Proj_Matri[1][0] +
		m_CubeThPoints[3].y * m_Proj_Matri[1][1] +
		m_CubeThPoints[3].z * m_Proj_Matri[1][2] +
		m_Proj_Matri[1][3];

	//第五个顶点
	m_Cube2DPoints[4].x =
		m_CubeThPoints[4].x * m_Proj_Matri[0][0] +
		m_CubeThPoints[4].y * m_Proj_Matri[0][1] +
		m_CubeThPoints[4].z * m_Proj_Matri[0][2] +
		m_Proj_Matri[0][3];
	m_Cube2DPoints[4].y =
		m_CubeThPoints[4].x * m_Proj_Matri[1][0] +
		m_CubeThPoints[4].y * m_Proj_Matri[1][1] +
		m_CubeThPoints[4].z * m_Proj_Matri[1][2] +
		m_Proj_Matri[1][3];

	//第六个顶点
	m_Cube2DPoints[5].x =
		m_CubeThPoints[5].x * m_Proj_Matri[0][0] +
		m_CubeThPoints[5].y * m_Proj_Matri[0][1] +
		m_CubeThPoints[5].z * m_Proj_Matri[0][2] +
		m_Proj_Matri[0][3];
	m_Cube2DPoints[5].y =
		m_CubeThPoints[5].x * m_Proj_Matri[1][0] +
		m_CubeThPoints[5].y * m_Proj_Matri[1][1] +
		m_CubeThPoints[5].z * m_Proj_Matri[1][2] +
		m_Proj_Matri[1][3];

	//第七个顶点
	m_Cube2DPoints[6].x =
		m_CubeThPoints[6].x * m_Proj_Matri[0][0] +
		m_CubeThPoints[6].y * m_Proj_Matri[0][1] +
		m_CubeThPoints[6].z * m_Proj_Matri[0][2] +
		m_Proj_Matri[0][3];
	m_Cube2DPoints[6].y =
		m_CubeThPoints[6].x * m_Proj_Matri[1][0] +
		m_CubeThPoints[6].y * m_Proj_Matri[1][1] +
		m_CubeThPoints[6].z * m_Proj_Matri[1][2] +
		m_Proj_Matri[1][3];

	//第八个顶点
	m_Cube2DPoints[7].x =
		m_CubeThPoints[7].x * m_Proj_Matri[0][0] +
		m_CubeThPoints[7].y * m_Proj_Matri[0][1] +
		m_CubeThPoints[7].z * m_Proj_Matri[0][2] +
		m_Proj_Matri[0][3];
	m_Cube2DPoints[7].y =
		m_CubeThPoints[7].x * m_Proj_Matri[1][0] +
		m_CubeThPoints[7].y * m_Proj_Matri[1][1] +
		m_CubeThPoints[7].z * m_Proj_Matri[1][2] +
		m_Proj_Matri[1][3];
}


//画矩形
void CCGWORK0933View::DrawRect(CPoint p1, CPoint p2, CPoint p3, CPoint p4) {
	CClientDC dc(this);
	dc.MoveTo(p1);
	dc.LineTo(p2);
	dc.LineTo(p3);
	dc.LineTo(p4);
	dc.LineTo(p1);
}

//画立方体
void CCGWORK0933View::DrawCube() {
	DrawRect(m_Cube2DPoints[1-1], m_Cube2DPoints[2-1], m_Cube2DPoints[6-1], m_Cube2DPoints[5-1]);
	DrawRect(m_Cube2DPoints[2-1], m_Cube2DPoints[4-1], m_Cube2DPoints[8-1], m_Cube2DPoints[6-1]);
	DrawRect(m_Cube2DPoints[4-1], m_Cube2DPoints[8-1], m_Cube2DPoints[7-1], m_Cube2DPoints[3-1]);
	DrawRect(m_Cube2DPoints[1-1], m_Cube2DPoints[3-1], m_Cube2DPoints[7-1], m_Cube2DPoints[5-1]);
	DrawRect(m_Cube2DPoints[5-1], m_Cube2DPoints[6-1], m_Cube2DPoints[8-1], m_Cube2DPoints[7-1]);
	//DrawRect(m_Cube2DPoints[1-1], m_Cube2DPoints[2-1], m_Cube2DPoints[3-1], m_Cube2DPoints[4-1]);
}

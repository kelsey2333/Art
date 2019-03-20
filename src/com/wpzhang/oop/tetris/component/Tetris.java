/**
 * @Author wpzhang
 * @Date 2019/3/19
 * @Description
 */
package com.wpzhang.oop.tetris.component;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @program: Wpzhang
 * @description: 俄罗斯方块
 * @author: wpzhang
 * @create: 2019-03-19 14:00
 **/

public class Tetris extends JPanel {
    public Tetris() {
        //构造器就是给成员变量赋值，currentTetrimino就是成员变量，所赋的值就是随机生成的OLT型方块
        currentTetrimino = generateRandomTetromino();
        nextTetrimino = generateRandomTetromino();

        // 给游戏面板添加监听响应事件, (按某一个按键, 则触发某一个响应(一段程序代码))
        // 给键盘添加监听响应事件
         addKeyBoardLister();

        // 初始化定时器
        timer = new Timer();
        // 给定时器分配定时任务, 设置定时执行的时间
        timer.schedule(new TimerTask() {
            // 定时任务方法, 每隔20ms, 执行一次run方法
            @Override
            public void run() {
                // 定时刷新游戏面板
                repaint();
            }
        }, 0, 20);
    }


    /**
     * 游戏面板的属性
     */
    private static Image backImg;   // 游戏面板背景图片
    private static Image tBackImg;   // t方块背景图片
    private static Image oBackImg;   // o方块背景图片
    private static Image lBackImg;   //l型方块背景图片
    private static Image jBackImg;   //j型方块背景图片
    private static Image iBackImg;   //i型方块背景图片
    private static Image sBackImg;   //s型方块背景图片

    private static final int ROW = 18;  // 游戏面板行数
    private static final int COL = 9;   // 游戏面板列数
    private static final int LEFTCOL = 1;   // 游戏面板左列数



    // Tetrimino:父类类型, 可以保存任何子类对象的地址
    // 积木类型不确定, 所以用父类类型去接收, 提高程序的可扩展性(多态)
    private Tetromino currentTetrimino; // 正在移动的积木
    private Tetromino nextTetrimino; // 即将移动的积木

    // 定时器
    private Timer timer;

    static {
        // 加载初始化游戏的素材资源(图片)
        try {
            backImg = ImageIO.read(Tetris.class.getClassLoader().getResourceAsStream("TETRIS.png"));
            tBackImg = ImageIO.read(Tetris.class.getClassLoader().getResourceAsStream("T.png"));
            oBackImg = ImageIO.read(Tetris.class.getClassLoader().getResourceAsStream("O.png"));
            lBackImg = ImageIO.read(Tetris.class.getClassLoader().getResourceAsStream("L.png"));
            jBackImg = ImageIO.read(Tetris.class.getClassLoader().getResourceAsStream("J.png"));
            iBackImg = ImageIO.read(Tetris.class.getClassLoader().getResourceAsStream("I.png"));
            sBackImg = ImageIO.read(Tetris.class.getClassLoader().getResourceAsStream("S.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // 重写父类的绘制方法
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // 扩展自定义的绘制功能
        // 绘制游戏背景图片  backImg: 游戏背景  0: 在面板上绘制的x坐标  : y坐标, null
        g.drawImage(backImg, 0, 0, null);

        // 绘制正在运动的积木
        currentTetrimino.paint(g);

        // 绘制即将出现的积木, 使用偏移量的绘制方法
        nextTetrimino.paint(g, 250, 0);
    }

    /**
     * @return com.itek.tetris.component.Tetrimino
     * @Param
     * @description 随机生成积木方块
     * @date 2019/3/19 0019 10:42
     */
    public Tetromino generateRandomTetromino() {
    //有返回值的 返回值类型为Tetromino的方法，随机返回T O 等型的积木对象
        int randomVal = (int) (Math.random() * 7);
        switch (randomVal) {
            case 0:
                // 创建一个T型积木对象，用p接收， 返回p
               /*
                TetrominoT p= new TetrominoT(1,5,tBackImg);
                return p;
                */
               //等同于
                return new TetrominoO(1, 5, oBackImg);
            case 1:
                // 返回一个O型积木对象
                return new TetrominoO(1, 5, oBackImg);
            case 2:
                // TODO返回一个L型积木对象
                return new TetrominoL(1,5,lBackImg);
            case 3:
                // TODO返回一个J型积木对象
                return new TetrominoJ(1,5,jBackImg);
            case 4:
                //TODO返回一个I型积木对象
                return new TetrominoI(1,5,iBackImg);
            case 5:
                //TODO返回一个s型积木对象
                return new TetrominoS(1,5,sBackImg);
            default:
                // TODO
//                System.out.println("未知积木类型");
                // 返回一个T型积木对象
                return new TetrominoT(1, 5, tBackImg);
        }
    }

    /**
     * @return void
     * @Param
     * @description 给面板添加键盘监听响应事件
     * @date 2019/3/19 0019 11:17
     */
    private void addKeyBoardLister() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // 当键盘按下任意键时, 则会执行keyPressd方法
                super.keyPressed(e);//
                // 获取按下键盘按钮的编码值, 根据编码值,确定按下的按钮
                int code = e.getKeyCode();

                switch (code) {
                    case KeyEvent.VK_UP: // 键盘向上箭头
                        // 翻转正在运动的方块积木
                        break;
                    case KeyEvent.VK_DOWN:// 键盘向下箭头
                        // 判断积木是否到达边界
                        if (!isReachBottom(currentTetrimino)) {
                            currentTetrimino.drop();
                        }
                        break;
                    case KeyEvent.VK_LEFT: /// 键盘向左箭头
                        // 控制正在运动的方块积木左移
                        if (!isReachLeftSide(currentTetrimino)) {
                            currentTetrimino.moveLeft();
                        }
                        break;
                    case KeyEvent.VK_RIGHT:// 键盘向右箭头
                        // 控制正在运动的方块积木右移
                        if (!isReachRightSide(currentTetrimino))
                        currentTetrimino.moveRight();
                        break;
                }
            }
        });

        // 让游戏面板获取到焦点
        this.setFocusable(true);
        this.setRequestFocusEnabled(true);
    }

    /**
     * @return boolean
     * true: 到达下边界
     * false: 未到达下边界
     * @Param t={待判断是否到达边界的积木}
     * @description 判断积木是否已经到达下边界
     * @date 2019/3/19 0019 11:46
     */
    public boolean isReachBottom(Tetromino t) {//积木对象
        // 判断传入的积木对象是否到达下边界
        Cell[] cells = t.cells;//这个什么意思
        for (int i = 0; i < cells.length; i++) {
             /*
                只要有一个数组元素row值达到了行最大值ROW,
                 则达到了下边界
            */
            if (cells[i].row >= ROW) {
                // 到达边界不能向下移动
                return true;
            }
        }
        // 未到达下边界
        return false;
    }
    public boolean isReachRightSide(Tetromino s) {
        // 判断传入的积木对象是否到达右边界
        Cell[] cells = s.cells;
        for (int i = 0; i < cells.length; i++) {
             /*
                只要有一个数组元素col值达到了列最大值COL,
                 则达到了右边界
            */
            if (cells[i].col >= COL) {
                // 到达边界不能向右移动
                return true;
            }
        }
        // 未到达下边界
        return false;
    }

    public boolean isReachLeftSide(Tetromino l) {
        // 判断传入的积木对象是否到达右边界
        Cell[] cells = l.cells;
        for (int i = 0; i < cells.length; i++) {
             /*
                只要有一个数组元素col值达到了列最大值COL,
                 则达到了右边界
            */
            if (cells[i].col<=LEFTCOL) {
                // 到达边界不能向右移动
                return true;
            }
        }
        // 未到达下边界
        return false;
    }
}
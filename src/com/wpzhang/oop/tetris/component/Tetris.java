/**
 * @Author wpzhang
 * @Date 2019/3/19
 * @Description
 */
package com.wpzhang.oop.tetris.component;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
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
        currentTetromino = generateRandomTetromino();
        nextTetromino = generateRandomTetromino();

        // 初始化wall数组
        wall = new Cell[ROW][COL]; /// 所有数组元素均为null值, 如果不为null值, 说明已经有积木落到底部, 不能再动了

        removeRows = 0;

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
    private static Image iBackImg;   // i方块背景图片
    private static Image lBackImg;   // l方块背景图片
    private static Image jBackImg;   // j方块背景图片
    private static Image sBackImg;   // s方块背景图片
    private static Image zBackImg;   // z方块背景图片

    private static final int ROW = 18;  // 游戏面板行数
    private static final int COL = 9;   // 游戏面板列数

    private static final int COL_START = 1; // 起始列数


    // Tetrimino:父类类型, 可以保存任何子类对象的地址
    // 积木类型不确定, 所以用父类类型去接收, 提高程序的可扩展性(多态)
    private Tetromino currentTetromino; // 正在移动的积木
    private Tetromino nextTetromino; // 正在移动的积木

    private Cell[][] wall;  /// 存储已经落到底部的积木方块二位数组

    private int removeRows; // 保存消除的行数


    // 定时器
    private Timer timer;


    static {
        // 加载初始化游戏的素材资源(图片)
        try {
            backImg = ImageIO.read(Tetris.class.getClassLoader().getResourceAsStream("TETRIS.png"));
            tBackImg = ImageIO.read(Tetris.class.getClassLoader().getResourceAsStream("T.png"));
            oBackImg = ImageIO.read(Tetris.class.getClassLoader().getResourceAsStream("O.png"));
            iBackImg = ImageIO.read(Tetris.class.getClassLoader().getResourceAsStream("I.png"));
            lBackImg = ImageIO.read(Tetris.class.getClassLoader().getResourceAsStream("L.png"));
            jBackImg = ImageIO.read(Tetris.class.getClassLoader().getResourceAsStream("J.png"));
            sBackImg = ImageIO.read(Tetris.class.getClassLoader().getResourceAsStream("S.png"));
            zBackImg = ImageIO.read(Tetris.class.getClassLoader().getResourceAsStream("Z.png"));
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
        currentTetromino.paint(g);

        // 绘制即将出现的积木, 使用偏移量的绘制方法
        nextTetromino.paint(g, 250, 0);

        // TODO 绘制已经固定不变的积木单元格wall[ROW][COL]
        paintWall(g);


        Font font = new Font("幼圆", Font.BOLD, 32);
        g.setFont(font);
//       TODO  g.setColor(Color.RED);
        g.setColor(new Color(255, 120, 128));
//        g.setFont(new Font("微软雅黑", Font.BOLD, 32));
        // 绘制消除的行数
        g.drawString("消除的行数 " + Integer.toString(removeRows), 300, 300);
    }

    /**
     * @return com.itek.tetris.component.Tetrimino
     * @Param
     * @description 随机生成积木方块
     * @date 2019/3/19 0019 10:42
     */
    public Tetromino generateRandomTetromino() {

        int randomVal = (int) (Math.random() * 7);


        switch (randomVal) {
            case 0:
                // 返回一个T型积木对象
                return new TetrominoT(1, 5, tBackImg);
            case 1:
                // 返回一个O型积木对象
                return new TetrominoO(1, 5, oBackImg);
            case 2:
                // 返回一个I型积木对象
                return new TetrominoI(1, 5, iBackImg);
            case 3:
                // 返回一个J型积木对象
                return new TetrominoJ(1, 5, jBackImg);

            case 4:
                // 返回一个S型积木对象
                return new TetrominoS(1, 5, sBackImg);
            case 5:
                // 返回一个L型积木对象
                return new TetrominoL(1, 5, lBackImg);
            case 6:
                //返回一个Z型积木对象
                return new TetrominoT(1, 5, zBackImg);
            default:
                // 返回一个J型积木对象
                return new TetrominoJ(1, 5, jBackImg);
        }
    }

    /**
     * @return void
     * @Param
     * @description 给面板添加键盘监听响应事件
     * @date 2019/3/19 0019 11:17
     */

    public void run() {

    }

    private void addKeyBoardLister() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // 当键盘按下任意键时, 则会执行keyPressd方法
                super.keyPressed(e);
                // 获取按下键盘按钮的编码值, 根据编码值,确定按下的按钮
                int code = e.getKeyCode();

                switch (code) {
                    case KeyEvent.VK_UP: // 键盘向上箭头
                        // 翻转正在运动的方块积木
                        // TODO 判断积木是否翻转之后越出边界
                        currentTetromino.rotate(true); // 向右翻转

                        if (isOutBounds(currentTetromino)) {
                            // 如果已经越界, 再翻转回来
                            currentTetromino.rotate(false);
                        }
                        break;

                    case KeyEvent.VK_DOWN:

                        // 判断积木是否到达边界 并且还要判断是否已经撞墙了(wall数组)
                        if (!isReachBottom(currentTetromino)) {
                            currentTetromino.drop();
                            // 判断向下移动之后, 是否撞墙
                            if (hitWall(currentTetromino)) {
                                // 回退, 将当前元素, 加入到wall数组中
                                currentTetromino.drop(-1);
                                // 将积木加入到墙体中wall
                                joinWall(currentTetromino);
                            }
                        } else {
                            // 1. 已经到达边界, 当前积木加入到当前面板的底部,
                            joinWall(currentTetromino);
                        }
                        break;
                    case KeyEvent.VK_LEFT: // 键盘向上箭头
                        // 控制正在运动的方块积木左移
                        if (!isReachLeft(currentTetromino)) {
                            currentTetromino.moveLeft();

                            // 判断是否已经撞墙
                            if (hitWall(currentTetromino)) {
                                // 如果已经撞墙, 再向右移动回去
                                currentTetromino.moveRight();
                            }

                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        // 控制正在运动的方块积木右移
                        if (!isReachRight(currentTetromino)) {
                            currentTetromino.moveRight();
                            // 判断是否已经撞墙
                            if (hitWall(currentTetromino)) {
                                // 如果已经撞墙, 再向右移动回去
                                currentTetromino.moveLeft();
                            }
                        }
                        break;
                }
            }
        });

        // 让游戏面板获取到焦点
        setFocusable(true);
        setRequestFocusEnabled(true);
    }

    /**
     * @return boolean
     * true: 到达下边界
     * false: 未到达下边界
     * @Param t={待判断是否到达边界的积木}
     * @description 判断积木是否已经到达下边界
     * @date 2019/3/19 0019 11:46
     */
    public boolean isReachBottom(Tetromino t) {
        // 判断传入的积木对象是否到达下边界
        Cell[] cells = t.cells;
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

    /**
     * @return
     * @Param No such property: code for class: Script1
     * @description 判断是否到了左边界
     * @date 2019/3/19 2019/3/19
     */
    public boolean isReachLeft(Tetromino t) {
        Cell[] cells = t.cells;
        for (int num = 0; num < cells.length; num++) {
            if (cells[num].col <= COL_START) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return
     * @Param No such property: code for class: Script1
     * @description 判断是否到了右边界
     * @date 2019/3/19 2019/3/19
     */
    public boolean isReachRight(Tetromino t) {
        Cell[] cells = t.cells;
        for (int num = 0; num < cells.length; num++) {
            if (cells[num].col >= COL) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return boolean
     * @Param t={}
     * @description TODO 描述功能
     * @date 2019/3/20 0020 9:45
     */
    private boolean isOutBounds(Tetromino t) {
        for (int i = 0; i < currentTetromino.cells.length; i++) {
            if (currentTetromino.cells[i].row < 1 ||
                    currentTetromino.cells[i].row > ROW ||
                    currentTetromino.cells[i].col < 1 ||
                    currentTetromino.cells[i].col > COL
            ) {
                // 已经越界
                return true;
            }
        }
        // 未越界
        return false;
    }

    /**
     * @return void
     * @Param g={当前面板的画笔}
     * @description 绘制已经固定不变的积木
     * @date 2019/3/20 0020 10:31
     */
    public void paintWall(Graphics g) {

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                // 判断当前遍历的数组元素是否为null值
                // 如果为null, 说明没有积木单元格, 否则,有积木单元格
                if (wall[i][j] != null) {
                    // 绘制积木单元格
                    wall[i][j].paint(g);
                }
            }
        }
    }

    /**
     * @return boolean
     * true : 撞墙
     * false: 为撞墙
     * @Param t={待判断的积木}
     * @description 判断传入的积木是否已经撞墙了
     * @date 2019/3/20 0020 10:35
     */
    public boolean hitWall(Tetromino t) {
        // 取出积木中的四个积木单元格
        Cell[] cells = t.cells;
        // 和wall数组中的坐标进行对比, 找出对应坐标中wall数组元素是否为null值或者不为null值
        // 4个数组元素中坐标所对应的wall数组元素都为null值, 说明未和墙发生碰撞
        // 4个数组元素中坐标所对应的wall数组元素如果有一个不为null值,说明已经撞墙

        for (int i = 0; i < cells.length; i++) {
            int row = cells[i].row;
            int col = cells[i].col;

            if (wall[row - 1][col - 1] != null) {
                return true;
            }
        }

        return false;
    }

    /**
     * @return void
     * @Param t={}
     * @description 将当前积木加入到墙体中wall数组
     * @date 2019/3/20 0020 10:44
     */
    public void joinWall(Tetromino t) {
        Cell[] cells = t.cells;
        // 1.2 将四个积木单元格添加到对应位置的wall数组中
        // 数组的下边wall[row - 1][ col - 1]
        for (int i = 0; i < cells.length; i++) {
            int row = cells[i].row;
            int col = cells[i].col;
            wall[row - 1][col - 1] = cells[i];
        }
        // 2. 判断墙体是否需要消减
        // 2.1 循环判断当前wall数组中所有的行, 检测行中元素是否都不为null值, 如果都不为null值,则进行消减
        for (int row = 0; row < ROW; row++) {

            // 检测行中的元素是否都不为null值
            boolean isNeedRemove = true; // 需要消减
            for (int col = 0; col < COL; col++) {
                if (wall[row][col] == null) {
                    // 不需要消减
                    isNeedRemove = false;
                    break; // 跳出内层循环
                }
            }

            // isNeedRemove判断是否需要清空行
            if (isNeedRemove) {
                removeRows++; // 统计消除的行

                wall[row] = new Cell[COL]; // 清空行, 并且设置为null值
                // 遍历上方所有的行, 让每行中的单元格向下移动
                for (int i = row - 1; i >= 0; i--) {
                    // 修改单元格的行坐标
                    for (int j = 0; j < COL; j++) {
                        if (wall[i][j] != null) {
                            wall[i][j].drop();
                        }
                    }

                    // 调换行
                    wall[i + 1] = wall[i];
                }

                // 将第0行重新清空赋值
                wall[0] = new Cell[COL];


            }
        }


        // 3. 将下一个即将出现的积木,放置到游戏面板的初始位置
        currentTetromino = nextTetromino; // 将next指向的积木对象,赋值给current对象
        // 4. 再随机生成下一个即将出现的积木
        nextTetromino = generateRandomTetromino(); // 将next指向随机生成的积木
    }
}
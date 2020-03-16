package com.monday.flyweight.chess.flyweightedition;


import java.util.HashMap;
import java.util.Map;

/**
 * 所有的ChessBoard对象共享30个（所有的棋子）
 */
public class ChessBoard {
    private Map<Integer, ChessPiece> chessPieces = new HashMap<>();

    public ChessBoard() {
        init();
    }

    private void init() {
        chessPieces.put(1, new ChessPiece(
                ChessPieceUnitFactory.getChessPiece(1), 0,0));
        chessPieces.put(2, new ChessPiece(
                ChessPieceUnitFactory.getChessPiece(2), 1,0));
        //...省略摆放其他棋子的代码...
    }

    public void move(int chessPieceId, int toPositionX, int toPositionY) {
        //...省略...
    }
}
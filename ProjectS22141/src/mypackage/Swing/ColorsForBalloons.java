package mypackage.Swing;

import java.awt.Color;

public enum ColorsForBalloons {
    COLOR1(1){
        Color col = new Color(70,152,255);
    },
    COLOR2(2){
        Color col = new Color(111,99,255);
    },
    COLOR3(3){
        Color col = new Color(252,186,3);
    },
    COLOR4(4){
        Color col = new Color(157,252,3);
    },
    COLOR5(5){
        Color col = new Color(23,221,235);
    },
    COLOR6(6){
        Color col = new Color(245,141,238);
    },
    COLOR7(7){
        Color col = new Color(240,50,95);
    },
    COLOR8(8){
        Color col = new Color(255,187,173);
    },
    COLOR9(9){
        Color col = new Color(150,0,222);
    },
    COLOR10(10){
        Color col = new Color(136,61,0);
    },
    COLOR11(11){
        Color col = new Color(13,164,56);
    },
    COLOR12(12){
        Color col = new Color(136,85,0);
    },
    COLOR13(13){
        Color col = new Color(0,63,0);
    },
    COLOR14(14){
        Color col = new Color(13,15,255);
    },
    COLOR15(15){
        Color col = new Color(35,0,96);
    },
    COLOR16(16){
        Color col = new Color(45,42,45);
    },
    UNKNOWN(17){
        Color col = new Color(0,0,0);
    };

    int colorId;

    ColorsForBalloons(int colorId){
        this.colorId=colorId;
    }

    public ColorsForBalloons getColor(int a){
        for(ColorsForBalloons e : values()) {
            if(e.colorId == a) return e;
        }
        return UNKNOWN;
    }

    @Override
    public String toString(){
        return ""+colorId;
    }
}

package org.firstinspires.ftc.teamcode.autons;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class SWEEPER {
    private Servo Sweeper;

    public SWEEPER(HardwareMap hardwareMap) {
        Sweeper = hardwareMap.get(Servo.class, "Sweeper");
        Sweeper.scaleRange(0.085,0.482);
    }

    public class MoveSweeper implements Action {
        ElapsedTime time = new ElapsedTime();
        boolean start;
        double runTime;
        double pos;
        public MoveSweeper(double pos){
            start = false;
            runTime = 0;
            this.pos = pos;
        }
        public MoveSweeper(double pos, double runt){
            start = false;
            runTime = runt;
            this.pos = pos;
        }
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (!start) {
                time.reset();
                start = true;
            }
            if (time.seconds() < runTime) {
                return true;
            } else {
                Sweeper.setPosition(pos); //0.28 //0.65
                return false;
            }
        }
    }
    public Action RotatePosition0() {
        return new MoveSweeper(/*0.26*/0);
    }
    public Action RotatePosition0(double runt) {
        return new MoveSweeper(/*0.26*/0, runt);
    }
    public Action RotatePosition1() {
        return new MoveSweeper(1);
    }
    public Action RotatePosition1(double runt) {
        return new MoveSweeper(1, runt);
    }

    public Action RotatePositionNegative1() {
        return new MoveSweeper(-0.064);
    }
    public Action RotatePositionNegative1(double runt) {
        return new MoveSweeper(-0.064,runt);
    }
}
package org.firstinspires.ftc.teamcode.autons;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class CLAW_NEW {
    private Servo Claw;
    public CLAW_NEW(HardwareMap hardwareMap) {
        Claw = hardwareMap.get(Servo.class, "Claw");
        Claw.scaleRange(0.45,1);
    }


    public class MoveClaw implements Action {
        ElapsedTime time = new ElapsedTime();
        boolean start;
        double runTime;
        double pos;
        public MoveClaw(double pos){
            start = false;
            runTime = 0;
            this.pos = pos;
        }
        public MoveClaw(double pos, double runt){
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
                Claw.setPosition(pos); //0.28 //0.65
                return false;
            }
        }
    }
    public Action closeClaw() {
        return new MoveClaw(1);
    }
    public Action closeClaw(double runt) {
        return new MoveClaw(1, runt);
    }
    public Action openClaw() {
        return new MoveClaw(0);
    }
    public Action openClaw(double runt) {
        return new MoveClaw(0, runt);
    }
    public Action openClaw_Left() {
        return new MoveClaw(-0.3);
    }
    public Action openClaw_Left(double runt) {
        return new MoveClaw(-0.3, runt);
    }
    public Action openSlightly() {
        return new MoveClaw(0.8);
    }
    public Action openSlightly(double runt) {
        return new MoveClaw(0.8, runt);
    }
}

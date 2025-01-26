package org.firstinspires.ftc.teamcode.autons;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class INTAKE_ANGLE_NEW {
    private Servo Intake_Angle;

    public INTAKE_ANGLE_NEW(HardwareMap hardwareMap) {
        Intake_Angle = hardwareMap.get(Servo.class, "Intake_Angle");
    }

    public class MoveIntakeAngle implements Action {
        ElapsedTime time = new ElapsedTime();
        boolean start;
        double runTime;
        double pos;
        public MoveIntakeAngle(double pos){
            start = false;
            runTime = 0;
            this.pos = pos;
        }
        public MoveIntakeAngle(double pos, double runt){
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
                Intake_Angle.setPosition(pos); //0.28 //0.65
                return false;
            }
        }
    }
    public Action RotatePosition0() {
        return new MoveIntakeAngle(0.26);
    }
    public Action RotatePosition0(double runt) {
        return new MoveIntakeAngle(0.26, runt);
    }
    public Action RotatePosition1() {
        return new MoveIntakeAngle(0.8);
    }
    public Action RotatePositionNegative1() {
        return new MoveIntakeAngle(-0.064);
    }
    public Action RotatePositionNegative1(double runt) {
        return new MoveIntakeAngle(-0.064,runt);
    }
}
package org.firstinspires.ftc.teamcode.autons;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class CLAW_ANGLE_NEW {
    private Servo Claw_Angle;
    public CLAW_ANGLE_NEW(HardwareMap hardwareMap) {
        Claw_Angle = hardwareMap.get(Servo.class, "Claw_Angle");
        Claw_Angle.scaleRange(0.04, 0.7);
    }

    public class MoveClawAngle implements Action {
        ElapsedTime time = new ElapsedTime();
        boolean start;
        double runTime;
        double pos;
        public MoveClawAngle(double pos){
            start = false;
            runTime = 0;
            this.pos = pos;
        }
        public MoveClawAngle(double pos, double runt){
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
                Claw_Angle.setPosition(pos);
                return false;
            }
        }
    }
    public Action forward() {
        return new MoveClawAngle(0);
    }
    public Action forward(double runt) {
        return new MoveClawAngle(0,runt);
    }
    public Action backward() {
        return new MoveClawAngle(1);
    }
    public Action backward(double runt) {
        return new MoveClawAngle(1,runt);
    }
}

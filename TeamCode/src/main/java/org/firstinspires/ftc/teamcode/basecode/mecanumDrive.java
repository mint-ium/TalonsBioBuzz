package org.firstinspires.ftc.teamcode.basecode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class mecanumDrive {

    DcMotorEx frontL;
    DcMotorEx frontR;
    DcMotorEx backL;
    DcMotorEx backR;
    public void init(HardwareMap hardwareMap){
        frontL = hardwareMap.get(DcMotorEx.class,"frontL");
        frontL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        frontR = hardwareMap.get(DcMotorEx.class,"frontR");
        frontR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        backL = hardwareMap.get(DcMotorEx.class,"backL");
        backL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        backR = hardwareMap.get(DcMotorEx.class,"backR");
        backR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void drive(double forward, double strafe, double rotate){
        double fr = (forward - strafe - rotate);
        double br = (forward + strafe - rotate);
        double fl = -(forward + strafe + rotate);
        double bl = -(forward - strafe + rotate);
        frontL.setPower(fl);
        frontR.setPower(fr);
        backL.setPower(bl);
        backR.setPower(br);
    }
}

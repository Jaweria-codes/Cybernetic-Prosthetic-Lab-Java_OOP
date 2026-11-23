# 🦾 Cybernetic Prosthetics & Biomechanics Diagnostic Engine

An interactive, console-based Java simulation where you act as a biomedical robotics engineer testing, calibrating, and stress-testing cybernetic prosthetic limbs on a diagnostic workbench.

Built from the ground up to demonstrate core **Object-Oriented Programming (OOP)** principles and **Data Structures** in Java without relying on traditional management systems.

---

##  Features

* **Device Selection:** Test distinct cybernetic prototypes—the **Aegis Neuro-Arm** (upper-body hydraulics) and **Zephyr Kinetic-X Leg** (lower-body impact & sprint dynamics).
* **Live Hardware Diagnostics:** View real-time battery charge, neural sync accuracy, pending movement queues, and limb-specific hardware specs.
* **Dual-Mode Neural Calibration:**
  * *Auto-Calibration:* Tunes neural receptors to safe factory defaults (`60Hz`).
  * *Manual Frequency Calibration:* Accepts custom frequency inputs (`Hz`) with sweet-spot boosts (`80–120Hz`) and overload penalties (`>120Hz`).
* **Biomechanical Stress Testing:** Simulates extreme physical loads tailored to each limb's specific capabilities (grip crushing force vs. vertical jump and shock absorption).
* **Motor Command History & Emergency Undo (`Stack`):** Logs sequential motor movements and safely reverses them in **Last-In, First-Out (LIFO)** order.

---

## 🧠 OOP Concepts Used

| OOP Concept | Implementation in Project |
| :--- | :--- |
| **Classes & Objects** | Modeled using `prostheticLimb`, `bionicArm`, `bionicLeg`, and `DiagnosticLab`, instantiated and managed inside `main`. |
| **Abstraction** | `prostheticLimb` is an `abstract` base class defining shared state and enforcing abstract methods (`runStressTest()`, `showSpecificSpecs()`). |
| **Encapsulation** | Sensitive attributes (`battery_level`, `neural_SyncScore`, `gripStrength`, `shockAbsorption`, `commandHistory`) are declared `private` and protected via `public` getters and setters. |
| **Inheritance** | `bionicArm` and `bionicLeg` extend `prostheticLimb`, inheriting shared attributes and stack methods while passing initialization values upward using `super(...)`. |
| **Method Overriding** | Subclasses use `@Override` on `runStressTest()` and `showSpecificSpecs()` to execute hardware-specific diagnostics. |
| **Runtime Polymorphism** | `DiagnosticLab` accepts the parent reference `prostheticLimb limb`, dynamically dispatching the correct subclass behavior at runtime. |
| **Method Overloading** | `DiagnosticLab` overloads `neuralCalibration(prostheticLimb)` and `neuralCalibration(prostheticLimb, int)` for automatic and manual frequency tuning. |
| **Stack (LIFO)** | `java.util.Stack<String>` tracks motor actions via `.push()`, `.pop()`, `.size()`, and `.isEmpty()` for step-by-step posture reversal. |

---

## 💻 Sample Terminal Output
<<< CYBERNETIC PROSTHETIC AND BIOMECHANICS DIAGNOSTIC ENGINE >>>
-------------------------------------------------------------------
WELCOME TO ROBOTICS SIMULATION TESTING!!
===========================================================
**********************************************************
Select prosthetic device to test:
 1. BIONIC ARM 
2. BIONIC LEG
Enter choice: 
1

'What test you want to run? 
1: Show limb status
2: Auto calibration
3: Manual calibration
4: Biomechanical stress test
5: Record motor command
6: Emergency undo
7: Exit test session!
type 1/2/3/....
3
Enter target frequency...
88
High precision tunning (88HZ)! Sync Boosted.

----------------------------------------------
'What test you want to run? 
1: Show limb status
2: Auto calibration
3: Manual calibration
4: Biomechanical stress test
5: Record motor command
6: Emergency undo
7: Exit test session!
type 1/2/3/....
5
Enter command. e.g: Rotate wrist/ Clench Fist/ Extend Forearm/ Flex knee joint/ Bend knee/ Grip object...clench fist
Executed and logged: [clench fist]

----------------------------------------------
'What test you want to run? 
1: Show limb status
2: Auto calibration
3: Manual calibration
4: Biomechanical stress test
5: Record motor command
6: Emergency undo
7: Exit test session!
type 1/2/3/....
7
Shutting down Dignostic lab. Good Bye!!

----------------------------------------------


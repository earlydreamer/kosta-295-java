package mvc.view;

import mvc.controller.ElectronicsController;

class StartView {
    
    public static void main(String []args) {
        System.out.println("===== 프로그램 시작합니다. =====");

        ElectronicsController.getInstance(); //View가 아닌 Controller의 생성자를 호출함

    }
    
}

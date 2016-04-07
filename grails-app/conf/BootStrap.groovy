class BootStrap {
    def subService
    def init = { servletContext ->
        new Thread(new Runnable() {
            @Override
            void run() {
                subService.sub()
            }
        }).start()
    }
    def destroy = {
    }
}

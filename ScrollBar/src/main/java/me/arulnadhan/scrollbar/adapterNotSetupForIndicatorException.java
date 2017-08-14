package me.arulnadhan.scrollbar;

 class adapterNotSetupForIndicatorException extends RuntimeException{

        adapterNotSetupForIndicatorException(String shouldExtend) {
            super("In order to add this indicator, the adapter for your recyclerView MUST implement " + shouldExtend + ".");
        }

}

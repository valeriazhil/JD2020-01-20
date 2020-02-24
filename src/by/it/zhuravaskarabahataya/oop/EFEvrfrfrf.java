package by.it.zhuravaskarabahataya.oop;


    class Upper
    {
        String upperString;

        public Upper()
        {
            Initializer.initialize(this);
        }
    }

    class Lower extends Upper
    {
        String lowerString = null;

        public Lower()
        {
            super();
            System.out.println("Upper:  " + upperString);
            System.out.println("Lower:  " + lowerString);
        }

        public static void main(final String[] args)
        {
            new Lower();
        }
    }

    class Initializer
    {
        static void initialize(final Upper anUpper)
        {
            if (anUpper instanceof Lower)
            {
                Lower lower = (Lower)anUpper;
                lower.lowerString = "lowerInited";
            }
            anUpper.upperString = "upperInited";
        }
    }


package MyTestLib;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Test {
    enum Priority {
        Level0(0),
        Level1(1),
        Level2(2),
        Level3(3),
        Level4(4),
        Level5(5),
        Level6(6),
        Level7(7),
        Level8(8),
        Level9(9);

        private int priority;

        Priority(int priority) {
            this.priority = priority;
        }

        public int getPriority() {
            return priority;
        }
    }

    Priority priority() default Priority.Level5;
}




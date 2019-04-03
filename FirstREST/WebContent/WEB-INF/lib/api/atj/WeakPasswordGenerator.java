package atj;

import javax.enterprise.context.Dependent;

@Dependent
@QWeakPasswordGenerator
public class WeakPasswordGenerator extends PasswordGenerator {
@Override
public String generate() { return "AlaMaKota"; }
}

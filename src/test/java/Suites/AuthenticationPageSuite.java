package Suites;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("homework")
@IncludeTags("authenticationPage")
public class AuthenticationPageSuite {}

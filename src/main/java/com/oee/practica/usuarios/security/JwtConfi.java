package com.oee.practica.usuarios.security;

public class JwtConfi {
	
	public static final String LLAVE_SECRETA="alguna.clave.secreta.12346";
	
	public static final String RSA_PRIVADA="-----BEGIN RSA PRIVATE KEY-----\r\n"
			+ "MIIEowIBAAKCAQEAzHCs1Kli5mlbdLEZs6HTuE3MbTNaSX/FTOzKqdgDKMjahdaN\r\n"
			+ "1p9EUe+dG247ny7Oj8GihBwfWOjXACdVmkXB+FMyFY8R+wV7l1o+juhKiTSnZ2OZ\r\n"
			+ "0T+jOCa94RTH1foh0nB0llM6w7fe7EnbsdDuU01yNYBjqKWpWYQwTYBymSOPIVz4\r\n"
			+ "pC+VNt86vL1nTg2WoLkvaRK/fttJHCzXspGygSn0cLbody5kqAOX+sYZ9Pr/Rn8F\r\n"
			+ "Gle7oNx4ILHWKyLhcdpoiX4b95TMIP9uwjg6Jaiy50SuJpJ2yN6GuEwXqgrL8vEi\r\n"
			+ "Fxv03mw/VFuBr7/5FCbi9rkczhq8ngPVpQI1qwIDAQABAoIBAQCBtdeiUhpi0GPr\r\n"
			+ "ZNZGx50aKZpTiqp1SbD3/qETI+/VN6KWGiwCCSkCx4GpvsXrWHpMcXHYWjN1aL3I\r\n"
			+ "5iwE5s+L69UyIoUo/DCPNf3NFAr+hL7V9TbJsZOwc7wzi8jCtaIx75G5MvNs7ENv\r\n"
			+ "LelLJ6GejtuwoFYa0YjiN+GhuqZ7DBchPqlUSXMZuxrOI4JGLNvZxpFl8cXjDzO2\r\n"
			+ "Z14O1ud89Qe6z9yn81I6eqZdDySbFzGaGYda3fyikBdJo7XwS2ri3HwsCqwxf4QG\r\n"
			+ "0K+1F3OOQi/mnYk6IbhnBkyKffPcoL7lj4DjJZ9L9KTsik8hd1HZMDhZAoasXdvQ\r\n"
			+ "+x18XLyRAoGBAO417783dP89ovVKJbroAy1BbtfR9RHr4zuaGG2Y62JDgobeMTjV\r\n"
			+ "XJqBUyMzveibLMGdJH8zNrQ8pKwzKW8cV6nO71NingwZb19sdY8Cq1kfEcwGYeoD\r\n"
			+ "ZHhh0urIXmRp4iE7uj+iSyRwxycjjhYjBPmUKprE+ujcUR1BaO6HEw4zAoGBANu1\r\n"
			+ "HrxXGIDWLy9hc02y5kpTklsCn1gtFokpLuqAjvWPbgG9TRp+j3ml3Kl0o/bl5tBh\r\n"
			+ "CWTbjWnrU9dRwDvWiDabRPnM/S54sUHwZTbMcP3UEDfEDsGm9QRKNAe/bF8K3PL0\r\n"
			+ "vdeJW3jBAaRh/I0l4wn83eCLqWhc6QB6VHFxGNKpAoGAZY0i5w7aVtHM/esdSKAO\r\n"
			+ "cqWZfnJomrpIRil8ToTJnDuRkrN4onT7JHcLnU86n8Y/f07ht0R7Br1vqmWpPVAE\r\n"
			+ "40Rv7Ml2/Ut+mlyfhVcq+zRunt79sQi/NT7m7uZ6ry4gk/BlhylGBYP6sunKcg99\r\n"
			+ "2HRc8VwWZ109S06OUFnPOtcCgYApyo/oH2EH0LX0+0JleywW40KpkRwiN6Fbwbus\r\n"
			+ "23tV9kxkhE+QRJah+wy4JvmxUxXOeUbCKokBpsOx51j7iNksGejK41Uda9O7yTBX\r\n"
			+ "dhfgEGBtWxu7djiQ8lRnTOAeTACvLiKWRwhhNcVMMV9KsfQ3yCOkPKyir1mav6ok\r\n"
			+ "UfD40QKBgDupehBDc7XQzwz+RWF7q11VRLqKxgBzbGUKv2v4atgI5SDg90vqEKTl\r\n"
			+ "CLpFZ7RUt1fZ83folhUhK9he3Y2jnKPmdkuPRkavSM1wxYtFb+DsFn48/J5Du5I9\r\n"
			+ "YjorfrrsRBRn0HWGNMo2zH3aEOR7K628WIH763kTsxCmhidjMJF8\r\n"
			+ "-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLICA="-----BEGIN PUBLIC KEY-----\r\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzHCs1Kli5mlbdLEZs6HT\r\n"
			+ "uE3MbTNaSX/FTOzKqdgDKMjahdaN1p9EUe+dG247ny7Oj8GihBwfWOjXACdVmkXB\r\n"
			+ "+FMyFY8R+wV7l1o+juhKiTSnZ2OZ0T+jOCa94RTH1foh0nB0llM6w7fe7EnbsdDu\r\n"
			+ "U01yNYBjqKWpWYQwTYBymSOPIVz4pC+VNt86vL1nTg2WoLkvaRK/fttJHCzXspGy\r\n"
			+ "gSn0cLbody5kqAOX+sYZ9Pr/Rn8FGle7oNx4ILHWKyLhcdpoiX4b95TMIP9uwjg6\r\n"
			+ "Jaiy50SuJpJ2yN6GuEwXqgrL8vEiFxv03mw/VFuBr7/5FCbi9rkczhq8ngPVpQI1\r\n"
			+ "qwIDAQAB\r\n"
			+ "-----END PUBLIC KEY-----";
	

}

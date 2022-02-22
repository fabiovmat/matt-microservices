package br.com.matt;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.matt.exception.UnsupportedMathException;

@RestController
public class MathController {

	
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathException("Please set a numeric value!");
		}
			
		Double sum = convertToDouble(numberOne)+ convertToDouble(numberTwo);
		return sum;
	}
	
	
	@RequestMapping(value = "/minus/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double minus(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathException("Please set a numeric value!");
		}

		Double minus = convertToDouble(numberOne)- convertToDouble(numberTwo);
		return minus;
		
	}
	
	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathException("Please set a numeric value!");
		}

		Double multiplication = convertToDouble(numberOne)* convertToDouble(numberTwo);
		return multiplication;
	
	}
	
	
	@RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathException("Please set a numeric value!");
		}

		Double division = convertToDouble(numberOne)/ convertToDouble(numberTwo);
		return division;
	
	}
	
	
	
	@RequestMapping(value = "/sqrt/{numberOne}", method = RequestMethod.GET)
	public Double sqrt(@PathVariable("numberOne") String numberOne ) throws Exception {
		if (!isNumeric(numberOne) ) {
			throw new UnsupportedMathException("Please set a numeric value!");
		}

		Double sqrt = Math.sqrt(convertToDouble(numberOne));
		return sqrt;
	
	}
	
	
	@RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathException("Please set a numeric value!");
		}

		Double mean = convertToDouble(numberOne) + convertToDouble(numberTwo) / 2;
		return mean;
	
	}

	
	
	
	private double convertToDouble(String strNumber) {
		if (strNumber == null) return 0D;
		String number  = strNumber.replaceAll(",", ".");
		if  (isNumeric(number)) return Double.parseDouble(number);
		return 0;
	}


	private boolean isNumeric(String strNumber) {
		if (strNumber == null) return false;
		String number  = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
}

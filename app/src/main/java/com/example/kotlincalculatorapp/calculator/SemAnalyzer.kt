package com.example.kotlincalculatorapp.calculator

import com.example.kotlincalculatorapp.nodes.Node

class SemAnalyzer {
    fun analyze(ast: Node): Node {
        // TODO: 1) Type Checking -- Operand Type Validity: Ensure that operations are being performed
        //  on valid types. For a scientific calculator, you might primarily deal with numeric types
        //  (e.g., integers, floating-point numbers). You need to ensure that operations like addition,
        //  subtraction, multiplication, and division are performed on compatible types.
        //  -- Function Arguments: If the calculator language includes functions
        //  (e.g., sin, cos, sqrt), ensure that the correct number and types of arguments are passed.
        //  For example, sqrt should only take a single numeric argument, and log might only accept
        //  positive numbers.
        //  2) Operator Validity -- Division by Zero -- Valid operators: Ensure that only supported
        //  operators are used
        //  3) Function and Variable Scope -- Variable Declaration Before Use: If the calculator
        //  language supports variables, ensure that variables are declared before they are
        //  used in any expressions. This avoids situations where a variable is referenced before
        //  it has a value.
        //  -- Scope Rules: Ensure that variables or functions are used within their correct scope.
        //  For instance, if the language supports nested expressions or functions,
        //  make sure that variable references are resolved correctly within the appropriate scope.
        //  4) Function Overloading and Arity Checking -- Arity Checking: Ensure that the number of
        //  arguments passed to a function matches the function’s signature.
        //  For instance, a sin function should not be called with two arguments.
        //  -- Function Overloading (if applicable): If your language supports function overloading
        //  (functions with the same name but different argument types or numbers),
        //  ensure that the correct function is resolved based on the arguments passed.
        //  5) Mathematical Domain Constraints -- Domain Constraints: Check that operations respect
        //  mathematical domain constraints. For example, the square root function should only be
        //  applied to non-negative numbers, logarithms should have positive arguments, and
        //  trigonometric functions might require angles in specific ranges
        //  (depending on how your calculator interprets inputs).
        //  6) Constant Evaluation and Folding -- Constant Folding: Although more of an optimization,
        //  constant expressions can be evaluated at this stage.
        //  This can help catch errors like log(0) or sqrt(-1) early, rather than during runtime.
        //  7) Unit Consistency (if applicable) -- Unit Checking: If your calculator language
        //  supports operations with units (e.g., meters, seconds),
        //  ensure that operations respect unit consistency.
        //  For instance, you cannot add meters to seconds, or take the square root
        //  of a unit with a dimension (like time).
        //  8) Complex Number Handling (if applicable) -- Complex Numbers: If the calculator language
        //  supports complex numbers, ensure that operations like addition, subtraction, multiplication,
        //  and division are valid between real and complex numbers, and that the correct mathematical
        //  rules are followed. 9) Error Propagation and Reporting -- Error Reporting: Ensure that
        //  all semantic errors are clearly reported to the user, indicating the exact location
        //  and nature of the error. This includes invalid operations, incorrect function usage,
        //  and out-of-bound calculations.
        return ast
    }
}
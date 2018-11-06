/**********************************************************************
Copyright (c) 2018 Andy Jefferson and others. All rights reserved.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Contributors:
     ...
 **********************************************************************/
package javax.jdo.query;

/**
 * Expression representing an "IF ... ELSE ..." construct.
 * 
 * @param <T> Java type being returned here
 */
public interface IfThenElseExpression<T> extends ComparableExpression<T>
{
    /**
     * Method to add an "IF (...) ..." clause.
     * If called multiple times, will add extra "IF (...) ..." or "ELSE IF (...) ..."
     * @param ifExpr The if expression
     * @param value The return value
     * @return This expression
     */
    IfThenElseExpression<T> ifThen(BooleanExpression ifExpr, T value);

    /**
     * Method to add an "IF (...) ..." clause.
     * If called multiple times, will add extra "IF (...) ..." or "ELSE IF (...) ..."
     * @param ifExpr The if expression
     * @param valueExpr The return value expression
     * @return This expression
     */
    IfThenElseExpression<T> ifThen(BooleanExpression ifExpr, Expression<T> valueExpr);

    /**
     * Method to add the "ELSE ..." clause.
     * If called multiple times will replace the previous else clause
     * @param value The return value
     * @return This expression
     */
    IfThenElseExpression<T> elseEnd(T value);

    /**
     * Method to add the "ELSE ..." clause.
     * If called multiple times will replace the previous else clause
     * @param valueExpr The return value expression
     * @return This expression
     */
    IfThenElseExpression<T> elseEnd(Expression<T> valueExpr);
}
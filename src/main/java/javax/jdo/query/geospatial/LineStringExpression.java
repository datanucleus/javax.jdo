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
package javax.jdo.query.geospatial;

import javax.jdo.query.BooleanExpression;
import javax.jdo.query.NumericExpression;

/**
 * Representation of a LineString expression.
 * Note that this is not part of the JDO spec, but a vendor extension to allow JDOQLTyped handling for geometry types.
 */
public interface LineStringExpression<T> extends GeometryExpression<T>
{
    /**
     * Returns TRUE if Curve/MultiCurve is closed and simple.
     * @return Whether it is closed and simple
     */
    BooleanExpression isRing();

    /**
     * Returns the first point of the Curve
     * @return The first point
     */
    GeometryExpression getStartPoint();

    /**
     * Returns the nth Point in the LineString.
     * @param position The "n" 
     * @return The nth Point of the LineString
     */
    GeometryExpression getPointN(NumericExpression position);

    /**
     * Returns the last point of the Curve
     * @return The last point
     */
    GeometryExpression getEndPoint();

    /**
     * Returns TRUE if Curve/MultiCurve is closed, i.e., if StartPoint(Curve) = EndPoint(Curve).
     * @return Whether it is closed
     */
    BooleanExpression isClosed();
}
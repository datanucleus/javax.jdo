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

import javax.jdo.query.NumericExpression;

/**
 * Representation of a Polygon expression.
 * Note that this is not part of the JDO spec, but a vendor extension to allow JDOQLTyped handling for geometry types.
 */
public interface PolygonExpression<T> extends GeometryExpression<T>
{
    /**
     * Returns the exterior ring of this Polygon.
     * @return The exterior ring
     */
    GeometryExpression getExteriorRing();

    /**
     * Returns the number of interior rings in the Polygon.
     * @return Number of interior rings
     */
    NumericExpression getNumInteriorRings();

    /**
     * Returns the nth interior ring in the Polygon.
     * @param position The "n" 
     * @return The nth interior ring of the Polygon
     */
    GeometryExpression getInteriorRingN(NumericExpression position);
}

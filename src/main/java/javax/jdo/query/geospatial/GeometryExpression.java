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
import javax.jdo.query.ComparableExpression;
import javax.jdo.query.NumericExpression;
import javax.jdo.query.ObjectExpression;
import javax.jdo.query.StringExpression;

/**
 * Representation of a geometry expression.
 * Note that this is not part of the JDO spec, but a vendor extension to allow JDOQLTyped handling for geometry types.
 */
public interface GeometryExpression<T> extends ComparableExpression<T>
{
    /**
     * Returns the rectangle bounding Geometry as a Polygon.
     * @return The bounding envelope
     */
    GeometryExpression getEnvelope();

    /**
     * Returns the dimension of the Geometry.
     * @return The dimension
     */
    NumericExpression getDimension();

    /**
     * Returns a Geometry that is the combinatorial boundary of the Geometry.
     * @return The boundary geometry
     */
    GeometryExpression getBoundary();

    /**
     * Returns the Spatial Reference System ID for this Geometry.
     * @return The SRID
     */
    NumericExpression getSRID();

    /**
     * Whether this Geometry is simple, as defined in the Geometry Model.
     * @return Whether it is simple
     */
    BooleanExpression isSimple();

    /**
     * Returns whether this Geometry corresponds to the empty set.
     * @return Whether it is empty
     */
    BooleanExpression isEmpty();

    /**
     * Returns the well-known textual representation.
     * @return The geometry as text
     */
    StringExpression toText();

    /**
     * Returns the well-known binary representation.
     * @return The geometry as binary
     */
    ObjectExpression toBinary();

    /**
     * Returns the name of the instantiable subtype of Geometry.
     * @return The type
     */
    StringExpression getGeometryType();

    /**
     * TRUE if the second Geometry is completely contained in first Geometry
     * @param geom The other geometry
     * @return Whether this contains the other geometry
     */
    BooleanExpression contains(GeometryExpression geom);

    /**
     * TRUE if this geometry is spatially overlapping the other Geometry.
     * @param geom The other geometry
     * @return Whether they overlap
     */
    BooleanExpression overlaps(GeometryExpression geom);

    /**
     * TRUE if this geometry spatially touches the other Geometry.
     * @param geom The other geometry
     * @return Whether they touch
     */
    BooleanExpression touches(GeometryExpression geom);

    /**
     * TRUE if this geometry crosses the other Geometry.
     * @param geom The other geometry
     * @return Whether they cross
     */
    BooleanExpression crosses(GeometryExpression geom);

    /**
     * TRUE if this geometry is completely contained in second Geometry.
     * @param geom The other geometry
     * @return Whether it is contained
     */
    BooleanExpression within(GeometryExpression geom);

    /**
     * TRUE if this Geometry spatially intersects the other Geometry.
     * @param geom The other geometry
     * @return Whether they intersect
     */
    BooleanExpression intersects(GeometryExpression geom);

    /**
     * TRUE if the two geometries are spatially equal.
     * @param geom The other geometry
     * @return Whether they are equals
     */
    BooleanExpression equals(GeometryExpression geom);

    /**
     * TRUE if the two geometries are spatially disjoint.
     * @param geom The other geometry
     * @return Whether they are disjoint
     */
    BooleanExpression disjoint(GeometryExpression geom);

    /**
     * TRUE if the spatial relationship specified by the pattern matrix holds
     * @param geom The geometry to relate to
     * @param pattern The pattern matrix
     * @return Whether they relate
     */
    BooleanExpression relate(GeometryExpression geom, StringExpression pattern);

    /**
     * Returns the distance to the other geometry.
     * @param geom The other geometry
     * @return The distance
     */
    NumericExpression distance(GeometryExpression geom);

    /**
     * Returns a Geometry that is the set intersection of the two geometries.
     * @param geom The other geometry
     * @return the intersection
     */
    GeometryExpression intersection(GeometryExpression geom);

    /**
     * Returns as Geometry defined by buffering a distance around the Geometry.
     * @param dist distance of the buffer
     * @return the buffered geometry
     */
    GeometryExpression buffer(NumericExpression dist);

    /**
     * Returns a Geometry that is the convex hull of the Geometry.
     * @return The convex hull geometry
     */
    GeometryExpression convexHull();

    /**
     * Returns a Geometry that is the closure of the set symmetric difference of the two geometries.
     * @param geom The other geometry
     * @return The sym difference
     */
    GeometryExpression symDifference(GeometryExpression geom);

    /**
     * Returns a Geometry that is the closure of the set difference of the two geometries.
     * @param geom The other geometry
     * @return The difference
     */
    GeometryExpression difference(GeometryExpression geom);

    /**
     * Returns a Geometry that is the set union of the two geometries.
     * @param geom The other geometry
     * @return The union of the two geometries
     */
    GeometryExpression union(GeometryExpression geom);

    // Curve

    /**
     * Returns the length of the Curve/MultiCurve.
     * @return The length
     */
    NumericExpression getLength();

    // LineString

    /**
     * Returns the number of points in the LineString.
     * @return The number of points
     */
    NumericExpression getNumPoints();

    // Surface/MultiSurface

    /**
     * Returns the centroid of Surface/MultiSurface, which may lie outside of it.
     * @return The centroid
     */
    GeometryExpression getCentroid();

    /**
     * Returns the area of Surface/MultiSurface.
     * @return The area
     */
    NumericExpression getArea();

    /**
     * Returns a Point guaranteed to lie on the surface.
     * @return The point
     */
    GeometryExpression getPointOnSurface();

    // GeomCollection

    /**
     * Returns the number of geometries in the collection.
     * @return Number of geometries
     */
    NumericExpression getNumGeometries();

    /**
     * Returns the nth geometry in the collection.
     * @param position The "n" 
     * @return The nth geometry of the collection
     */
    GeometryExpression getGeometryN(NumericExpression position);
}

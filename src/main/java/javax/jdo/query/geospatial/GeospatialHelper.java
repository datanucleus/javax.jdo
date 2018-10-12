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
import javax.jdo.query.StringExpression;

/**
 * Helper builder for (DataNucleus vendor extension) Geospatial features.
 */
public interface GeospatialHelper
{
    /**
     * Construct a GeometryExpression given its text and SRID expressions.
     * @param wktExpr well known text expression
     * @param sridExpr SRID expression
     * @return The geometry expression
     */
    GeometryExpression geometryFromText(StringExpression wktExpr, NumericExpression<Integer> sridExpr);

    /**
     * Construct a GeometryExpression given its text and SRID values.
     * @param wkt well known text
     * @param srid SRID
     * @return The geometry expression
     */
    GeometryExpression geometryFromText(String wkt, Integer srid);

    /**
     * Construct a PointExpression given its text and SRID expressions.
     * @param wktExpr well known text expression
     * @param sridExpr SRID expression
     * @return The geometry expression
     */
    PointExpression pointFromText(StringExpression wktExpr, NumericExpression<Integer> sridExpr);

    /**
     * Construct a PointExpression given its text and SRID values.
     * @param wkt well known text
     * @param srid SRID
     * @return The geometry expression
     */
    PointExpression pointFromText(String wkt, Integer srid);

    /**
     * Construct a LineStringExpression given its text and SRID expressions.
     * @param wktExpr well known text expression
     * @param sridExpr SRID expression
     * @return The geometry expression
     */
    LineStringExpression lineStringFromText(StringExpression wktExpr, NumericExpression<Integer> sridExpr);

    /**
     * Construct a LineStringExpression given its text and SRID values.
     * @param wkt well known text
     * @param srid SRID
     * @return The geometry expression
     */
    LineStringExpression lineStringFromText(String wkt, Integer srid);

    /**
     * Construct a PolygonExpression given its text and SRID expressions.
     * @param wktExpr well known text expression
     * @param sridExpr SRID expression
     * @return The geometry expression
     */
    PolygonExpression polygonFromText(StringExpression wktExpr, NumericExpression<Integer> sridExpr);

    /**
     * Construct a PolygonExpression given its text and SRID values.
     * @param wkt well known text
     * @param srid SRID
     * @return The geometry expression
     */
    PolygonExpression polygonFromText(String wkt, Integer srid);

    /**
     * Construct a MultiLineStringExpression given its text and SRID expressions.
     * @param wktExpr well known text expression
     * @param sridExpr SRID expression
     * @return The geometry expression
     */
    MultiLineStringExpression multiLineStringFromText(StringExpression wktExpr, NumericExpression<Integer> sridExpr);

    /**
     * Construct a MultiLineStringExpression given its text and SRID values.
     * @param wkt well known text
     * @param srid SRID
     * @return The geometry expression
     */
    MultiLineStringExpression multiLineStringFromText(String wkt, Integer srid);

    /**
     * Construct a MultiPointExpression given its text and SRID expressions.
     * @param wktExpr well known text expression
     * @param sridExpr SRID expression
     * @return The geometry expression
     */
    MultiPointExpression multiPointFromText(StringExpression wktExpr, NumericExpression<Integer> sridExpr);

    /**
     * Construct a MultiPointExpression given its text and SRID values.
     * @param wkt well known text
     * @param srid SRID
     * @return The geometry expression
     */
    MultiPointExpression multiPointFromText(String wkt, Integer srid);

    /**
     * Construct a MultiPolygonExpression given its text and SRID expressions.
     * @param wktExpr well known text expression
     * @param sridExpr SRID expression
     * @return The geometry expression
     */
    MultiPolygonExpression multiPolygonFromText(StringExpression wktExpr, NumericExpression<Integer> sridExpr);

    /**
     * Construct a MultiPolygonExpression given its text and SRID values.
     * @param wkt well known text
     * @param srid SRID
     * @return The geometry expression
     */
    MultiPolygonExpression multiPolygonFromText(String wkt, Integer srid);

/*
    if ("Spatial.geomCollFromText".equals(methodName)) return org.datanucleus.store.types.geospatial.rdbms.sql.method.SpatialGeomFromTextMethod3.class;

    if ("Spatial.geomFromWKB".equals(methodName)) return org.datanucleus.store.types.geospatial.rdbms.sql.method.SpatialGeomFromWKBMethod3.class;
    if ("Spatial.geomCollFromWKB".equals(methodName)) return org.datanucleus.store.types.geospatial.rdbms.sql.method.SpatialGeomFromWKBMethod3.class;                    
    if ("Spatial.pointFromWKB".equals(methodName)) return org.datanucleus.store.types.geospatial.rdbms.sql.method.SpatialGeomFromWKBMethod3.class;
    if ("Spatial.mPointFromWKB".equals(methodName)) return org.datanucleus.store.types.geospatial.rdbms.sql.method.SpatialGeomFromWKBMethod3.class;
    if ("Spatial.lineFromWKB".equals(methodName)) return org.datanucleus.store.types.geospatial.rdbms.sql.method.SpatialGeomFromWKBMethod3.class;
    if ("Spatial.mLineFromWKB".equals(methodName)) return org.datanucleus.store.types.geospatial.rdbms.sql.method.SpatialGeomFromWKBMethod3.class;
    if ("Spatial.polyFromWKB".equals(methodName)) return org.datanucleus.store.types.geospatial.rdbms.sql.method.SpatialGeomFromWKBMethod3.class;
    if ("Spatial.mPolyFromWKB".equals(methodName)) return org.datanucleus.store.types.geospatial.rdbms.sql.method.SpatialGeomFromWKBMethod3.class;
*/
}
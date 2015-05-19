/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 */
package javax.jdo;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.jdo.FetchPlan;
import javax.jdo.PersistenceManager;
import javax.jdo.query.BooleanExpression;
import javax.jdo.query.CharacterExpression;
import javax.jdo.query.CollectionExpression;
import javax.jdo.query.DateExpression;
import javax.jdo.query.DateTimeExpression;
import javax.jdo.query.Expression;
import javax.jdo.query.ListExpression;
import javax.jdo.query.MapExpression;
import javax.jdo.query.NumericExpression;
import javax.jdo.query.OrderExpression;
import javax.jdo.query.PersistableExpression;
import javax.jdo.query.StringExpression;
import javax.jdo.query.TimeExpression;

/**
 * Interface for a type-safe query, using a fluent API.
 * Designed to handle JDO query requirements as a whole.
 * @param <T> candidate type for this query
 */
public interface JDOQLTypedQuery<T>
{
    public static final String QUERY_CLASS_PREFIX = "Q";

    /**
     * Method to return an expression for the candidate of the query.
     * Cast the returned expression to the candidate "Q" type to be able to call methods on it.
     * This calls the method "Q{type}.candidate(null)"
     * The preference is to use the "Q{type}.candidate()" method for real type-safe handling.
     * @return Expression for the candidate
     */
    PersistableExpression<T> candidate();

    /**
     * Method to return a parameter for the query.
     * Cast the returned parameter to the right type to be able to call methods on it.
     * The preference is to use the "xxxParameter(String)" methods for real type-safe handling.
     * @param name Name of the parameter
     * @param type Java type of the parameter
     * @return Expression for the parameter
     * @param <P> type for the parameter
     */
    <P> Expression<P> parameter(String name, Class<P> type);

    /**
     * Method to return a string parameter for the query.
     * @param name Name of the parameter
     * @return StringExpression for the parameter
     */
    StringExpression stringParameter(String name);

    /**
     * Method to return a character parameter for the query.
     * @param name Name of the parameter
     * @return Expression for the parameter
     */
    CharacterExpression characterParameter(String name);

    /**
     * Method to return a numeric parameter for the query.
     * @param name Name of the parameter
     * @return NumericExpression for the parameter
     */
    NumericExpression<?> numericParameter(String name);

    /**
     * Method to return a date parameter for the query.
     * @param name Name of the parameter
     * @return Expression for the parameter
     */
    DateExpression dateParameter(String name);

    /**
     * Method to return a time parameter for the query.
     * @param name Name of the parameter
     * @return Expression for the parameter
     */
    TimeExpression timeParameter(String name);

    /**
     * Method to return a datetime parameter for the query.
     * @param name Name of the parameter
     * @return Expression for the parameter
     */
    DateTimeExpression datetimeParameter(String name);

    /**
     * Method to return a collection parameter for the query.
     * @param name Name of the parameter
     * @return Expression for the parameter
     */
    CollectionExpression<?, ?> collectionParameter(String name);

    /**
     * Method to return a map parameter for the query.
     * @param name Name of the parameter
     * @return Expression for the parameter
     */
    MapExpression<?, ?, ?> mapParameter(String name);

    /**
     * Method to return a list parameter for the query.
     * @param name Name of the parameter
     * @return Expression for the parameter
     */
    ListExpression<?, ?> listParameter(String name);

    /**
     * Method to return a variable for this query.
     * Cast the returned variable to the right type to be able to call methods on it.
     * @param name Name of the variable
     * @param type Type of the variable
     * @return Expression for the variable
     * @param <V> type for the variable
     */
    <V> Expression<V> variable(String name, Class<V> type);

    /**
     * Whether the query should ignore the cache and go straight to the datastore.
     * @param ignore Ignore the cache flag
     * @return The query
     */
    JDOQLTypedQuery<T> setIgnoreCache(boolean ignore);

    /**
     * Method to set the candidates to use over which we are querying.
     * If no candidates are set then the query is performed on the datastore.
     * @param candidates The candidates
     * @return The query
     */
    JDOQLTypedQuery<T> setCandidates(Collection<T> candidates);

    /**
     * Method to remove subclasses (of the candidate) from the query
     * @return The query
     */
    JDOQLTypedQuery<T> excludeSubclasses();

    /**
     * Method to include subclasses (of the candidate) to the query
     * @return The query
     */
    JDOQLTypedQuery<T> includeSubclasses();

    /**
     * Method to set the filter of the query.
     * @param expr Filter expression
     * @return The query
     */
    JDOQLTypedQuery<T> filter(BooleanExpression expr);

    /**
     * Method to set the grouping(s) for the query.
     * @param exprs Grouping expression(s)
     * @return The query
     */
    JDOQLTypedQuery<T> groupBy(Expression<?>... exprs);

    /**
     * Method to set the having clause of the query.
     * @param expr Having expression
     * @return The query
     */
    JDOQLTypedQuery<T> having(Expression<?> expr);

    /**
     * Method to set the ordering of the query.
     * @param orderExprs Ordering expression(s)
     * @return The query
     */
    JDOQLTypedQuery<T> orderBy(OrderExpression<?>... orderExprs);

    /**
     * Method to set the range of any required results, using expressions.
     * @param lowerInclExpr The position of the first result (inclusive)
     * @param upperExclExpr The position of the last result (exclusive)
     * @return The query
     */
    JDOQLTypedQuery<T> range(NumericExpression<?> lowerInclExpr, NumericExpression<?> upperExclExpr);

    /**
     * Method to set the range of any required results, using long values.
     * @param lowerIncl The position of the first result (inclusive)
     * @param upperExcl The position of the last result (exclusive)
     * @return The query
     */
    JDOQLTypedQuery<T> range(long lowerIncl, long upperExcl);

    /**
     * Method to set the range of any required results, using parameters (expressions).
     * @param paramLowerInclExpr Expression for a parameter defining the position of the first result (inclusive)
     * @param paramUpperExclExpr Expression for a parameter defining the position of the last result (exclusive)
     * @return The query
     */
    JDOQLTypedQuery<T> range(Expression<?> paramLowerInclExpr, Expression<?> paramUpperExclExpr);

    /**
     * Method to return a subquery for use in this query using the same candidate class as this query.
     * To obtain the expression for the subquery to link it back to this query, call "result(...)" on the subquery.
     * @param candidateAlias Alias for the candidate
     * @return The subquery
     */
    JDOQLTypedSubquery<T> subquery(String candidateAlias);

    /**
     * Method to return a subquery for use in this query.
     * To obtain the expression for the subquery to link it back to this query, call "result(...)" on the subquery.
     * @param candidate Candidate for the subquery
     * @param candidateAlias Alias for the candidate
     * @return The subquery
     * @param <S> candidate type for subquery
     */
    <S> JDOQLTypedSubquery<S> subquery(Class<S> candidate, String candidateAlias);

    /**
     * Method to set a parameter value for use when executing the query.
     * @param paramExpr Parameter expression
     * @param value The value
     * @return The query
     */
    JDOQLTypedQuery<T> setParameter(Expression<?> paramExpr, Object value);

    /**
     * Method to set a parameter value for use when executing the query.
     * @param paramName Parameter name
     * @param value The value
     * @return The query
     */
    JDOQLTypedQuery<T> setParameter(String paramName, Object value);

    /**
     * Method to clear all parameter values.
     * @return The query
     */
    JDOQLTypedQuery<T> clearParameters();

    /**
     * Add a vendor-specific extension to this query. The key and value are not standard.
     * An implementation must ignore keys that are not recognized.
     * @param key the key of the extension
     * @param value the value of the extension
     * @return The query
     */
    JDOQLTypedQuery<T> addExtension (String key, Object value);

    /**
     * Set multiple extensions, or use null to clear all extensions. Map keys and values are not standard.
     * @param extensions the map of extensions
     * @return The query
     * @see #addExtension
     */
    JDOQLTypedQuery<T> setExtensions (Map<String, Object> extensions);



    // Everything below here needs modification to fit in with JDO-652 and discussions on QueryExecution

    /**
     * Method to execute the query where there are (potentially) multiple rows and we are returning
     * the candidate type.
     * @return The results
     */
    List<T> executeList();

    /**
     * Method to execute the query where there is a single row and we are returning the candidate type.
     * @return The result
     */
    T executeUnique();

    /**
     * Method to execute the query where there are (potentially) multiple rows and we are returning either a
     * result type or the candidate type.
     * @param resultCls Result class
     * @param distinct Whether to provide distinct results
     * @param exprs Result expression(s)
     * @return The results
     * @param <R> result type
     */
    <R> List<R> executeResultList(Class<R> resultCls, boolean distinct, Expression<?>... exprs);

    /**
     * Method to execute the query where there is a single row and we are returning either a result type
     * or the candidate type.
     * @param resultCls Result class
     * @param distinct Whether to provide distinct results
     * @param exprs Result expression(s)
     * @return The result
     * @param <R> result type
     */
    <R> R executeResultUnique(Class<R> resultCls, boolean distinct, Expression<?>... exprs);

    /**
     * Method to execute the query where there are (potentially) multiple rows and we have a single result defined
     * but no result class.
     * @param distinct Whether to provide distinct results
     * @param expr Result expression
     * @return The results
     */
    List<Object> executeResultList(boolean distinct, Expression<?> expr);

    /**
     * Method to execute the query where there is a single row and we have a single result defined
     * but no result class.
     * @param distinct Whether to provide distinct results
     * @param expr Result expression
     * @return The results
     */
    Object executeResultUnique(boolean distinct, Expression<?> expr);

    /**
     * Method to execute the query where there are (potentially) multiple rows and we have a result defined
     * but no result class.
     * @param distinct Whether to provide distinct results
     * @param exprs Result expression(s)
     * @return The results
     */
    List<Object[]> executeResultList(boolean distinct, Expression<?>... exprs);

    /**
     * Method to execute the query where there is a single row and we have a result defined
     * but no result class.
     * @param distinct Whether to provide distinct results
     * @param exprs Result expression(s)
     * @return The results
     */
    Object[] executeResultUnique(boolean distinct, Expression<?>... exprs);

    /**
     * Method to execute the query deleting the affected instances.
     * @return The number of objects deleted
     */
    long deletePersistentAll();

    /**
     * Accessor for the PersistenceManager for this query
     * @return The PersistenceManager
     */
    PersistenceManager getPersistenceManager();

    /**
     * Accessor for the FetchPlan for this query
     * @return The FetchPlan
     */
    FetchPlan getFetchPlan();

    /**
     * Method to close the specified query result.
     * @param result The result
     */
    void close(Object result);

    /**
     * Method to close all query results from this query.
     */
    void closeAll();

    /**
     * Method to return the equivalent String form of this query (if applicable for the query language).
     * @return The single-string form of this query
     */
    String toString();
}
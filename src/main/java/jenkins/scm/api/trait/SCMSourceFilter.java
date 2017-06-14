/*
 * The MIT License
 *
 * Copyright (c) 2017, CloudBees, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package jenkins.scm.api.trait;

import edu.umd.cs.findbugs.annotations.NonNull;
import java.io.IOException;

/**
 * A {@link SCMNavigatorRequest} dependent filter of project names. Typically these filters may need to
 * make remote requests in order to determine exclusion.
 * If multiple filters are used, if any exclude then the project name is excluded.
 *
 * @see SCMSourcePrefilter for {@link SCMSourceRequest} independent filters / filters that can perform completely
 * off-line.
 * @since 3.4.0
 */
public abstract class SCMSourceFilter {

    /**
     * Checks if the supplied project name is excluded from the specified {@link SCMNavigatorRequest}.
     *
     * @param request     the {@link SCMNavigatorRequest}.
     * @param projectName the project name.
     * @return {@code true} if and only if the project name is excluded from the request.
     * @throws IOException          if there was an I/O error when determining exclusion.
     * @throws InterruptedException if interrupted while determining exclusion.
     */
    public abstract boolean isExcluded(@NonNull SCMNavigatorRequest request, @NonNull String projectName)
            throws IOException, InterruptedException;

}

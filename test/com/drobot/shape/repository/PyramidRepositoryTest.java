package test.com.drobot.shape.repository;

import com.drobot.shape.comparator.PyramidIdComparator;
import com.drobot.shape.comparator.PyramidVertexDistanceComparator;
import com.drobot.shape.entity.Point;
import com.drobot.shape.entity.pyramid.Pyramid;
import com.drobot.shape.entity.pyramid.TrianglePyramid;
import com.drobot.shape.repository.impl.PyramidRepository;
import com.drobot.shape.specification.Specification;
import com.drobot.shape.specification.impl.PyramidFirstQuadrantSpecification;
import com.drobot.shape.specification.impl.PyramidIdSpecification;
import com.drobot.shape.specification.impl.PyramidTypeSpecification;
import org.testng.annotations.Test;

import java.util.List;
import java.util.UUID;

public class PyramidRepositoryTest {

    @Test
    public void sortTest1() {
        PyramidIdComparator comparator = new PyramidIdComparator();
        Point point1 = new Point(2.0, 6.0, 7.0);
        Point point2 = new Point(4.0, 6.0, 7.0);
        Point point3 = new Point(2.0, 8.0, 7.0);
        Point point4 = new Point(2.0, 6.0, 10.0);
        List<Point> points1 = List.of(point1, point2, point3, point4);
        point1 = new Point(5.0, 3.0, 0.0);
        point2 = new Point(7.0, 6.0, 0.0);
        point3 = new Point(2.0, 8.0, 0.0);
        point4 = new Point(1.0, 6.0, -5.0);
        List<Point> points2 = List.of(point1, point2, point3, point4);
        point1 = new Point(12.0, 1.0, -7.0);
        point2 = new Point(1.0, 16.0, -7.0);
        point3 = new Point(3.0, 8.0, -7.0);
        point4 = new Point(11.0, 16.0, 0.0);
        List<Point> points3 = List.of(point1, point2, point3, point4);
        point1 = new Point(21.0, 0.0, 0.0);
        point2 = new Point(34.0, 15.0, 0.0);
        point3 = new Point(12.0, 18.0, 0.0);
        point4 = new Point(1.0, 3.0, 1.0);
        List<Point> points4 = List.of(point1, point2, point3, point4);
        point1 = new Point(12.0, -6.0, 5.0);
        point2 = new Point(14.0, 6.0, 5.0);
        point3 = new Point(24.0, -8.0, 5.0);
        point4 = new Point(2.0, 0.0, 15.0);
        List<Point> points5 = List.of(point1, point2, point3, point4);
        TrianglePyramid pyramid1 = new TrianglePyramid(UUID.randomUUID(), points1);
        TrianglePyramid pyramid2 = new TrianglePyramid(UUID.randomUUID(), points2);
        TrianglePyramid pyramid3 = new TrianglePyramid(UUID.randomUUID(), points3);
        TrianglePyramid pyramid4 = new TrianglePyramid(UUID.randomUUID(), points4);
        TrianglePyramid pyramid5 = new TrianglePyramid(UUID.randomUUID(), points5);
        PyramidRepository repository = PyramidRepository.getInstance();
        repository.add(pyramid1);
        repository.add(pyramid2);
        repository.add(pyramid3);
        repository.add(pyramid4);
        repository.add(pyramid5);
        repository.sort(comparator);
    }

    @Test
    public void sortTest2() {
        PyramidVertexDistanceComparator comparator = new PyramidVertexDistanceComparator();
        Point point1 = new Point(2.0, 6.0, 7.0);
        Point point2 = new Point(4.0, 6.0, 7.0);
        Point point3 = new Point(2.0, 8.0, 7.0);
        Point point4 = new Point(0.0, 6.0, 8.0);
        List<Point> points1 = List.of(point1, point2, point3, point4);
        point1 = new Point(5.0, 3.0, 0.0);
        point2 = new Point(7.0, 6.0, 0.0);
        point3 = new Point(2.0, 8.0, 0.0);
        point4 = new Point(0.0, 2.0, 3.0);
        List<Point> points2 = List.of(point1, point2, point3, point4);
        point1 = new Point(12.0, 1.0, -7.0);
        point2 = new Point(1.0, 16.0, -7.0);
        point3 = new Point(3.0, 8.0, -7.0);
        point4 = new Point(11.0, 16.0, 0.0);
        List<Point> points3 = List.of(point1, point2, point3, point4);
        point1 = new Point(21.0, 0.0, 0.0);
        point2 = new Point(34.0, 15.0, 0.0);
        point3 = new Point(12.0, 18.0, 0.0);
        point4 = new Point(1.0, 3.0, 1.0);
        List<Point> points4 = List.of(point1, point2, point3, point4);
        point1 = new Point(12.0, -6.0, 5.0);
        point2 = new Point(14.0, 6.0, 5.0);
        point3 = new Point(24.0, -8.0, 5.0);
        point4 = new Point(2.0, 0.0, 15.0);
        List<Point> points5 = List.of(point1, point2, point3, point4);
        TrianglePyramid pyramid1 = new TrianglePyramid(UUID.randomUUID(), points1);
        TrianglePyramid pyramid2 = new TrianglePyramid(UUID.randomUUID(), points2);
        TrianglePyramid pyramid3 = new TrianglePyramid(UUID.randomUUID(), points3);
        TrianglePyramid pyramid4 = new TrianglePyramid(UUID.randomUUID(), points4);
        TrianglePyramid pyramid5 = new TrianglePyramid(UUID.randomUUID(), points5);
        PyramidRepository repository = PyramidRepository.getInstance();
        repository.add(pyramid1);
        repository.add(pyramid2);
        repository.add(pyramid3);
        repository.add(pyramid4);
        repository.add(pyramid5);
        repository.sort(comparator);
    }

    @Test
    public void queryTest1() {
        Specification<Pyramid> specification = new PyramidFirstQuadrantSpecification<>();
        Point point1 = new Point(2.0, 6.0, 7.0);
        Point point2 = new Point(4.0, 6.0, 7.0);
        Point point3 = new Point(2.0, 8.0, 7.0);
        Point point4 = new Point(2.0, 6.0, 10.0);
        List<Point> points1 = List.of(point1, point2, point3, point4);
        point1 = new Point(5.0, 3.0, 0.0);
        point2 = new Point(7.0, 6.0, 0.0);
        point3 = new Point(2.0, 8.0, 0.0);
        point4 = new Point(1.0, 6.0, 5.0);
        List<Point> points2 = List.of(point1, point2, point3, point4);
        point1 = new Point(12.0, 1.0, -7.0);
        point2 = new Point(1.0, 16.0, -7.0);
        point3 = new Point(3.0, 8.0, -7.0);
        point4 = new Point(11.0, 16.0, 0.0);
        List<Point> points3 = List.of(point1, point2, point3, point4);
        point1 = new Point(21.0, 0.0, 0.0);
        point2 = new Point(-34.0, 15.0, 0.0);
        point3 = new Point(-12.0, 18.0, 0.0);
        point4 = new Point(1.0, 3.0, 1.0);
        List<Point> points4 = List.of(point1, point2, point3, point4);
        point1 = new Point(12.0, -6.0, 5.0);
        point2 = new Point(14.0, 6.0, 5.0);
        point3 = new Point(24.0, -8.0, 5.0);
        point4 = new Point(2.0, 0.0, 15.0);
        List<Point> points5 = List.of(point1, point2, point3, point4);
        point1 = new Point(5.0, 3.0, 1.0);
        point2 = new Point(7.0, 6.0, 1.0);
        point3 = new Point(2.0, 8.0, 1.0);
        point4 = new Point(1.0, 6.0, 5.0);
        List<Point> points6 = List.of(point1, point2, point3, point4);
        TrianglePyramid pyramid1 = new TrianglePyramid(UUID.randomUUID(), points1);
        TrianglePyramid pyramid2 = new TrianglePyramid(UUID.randomUUID(), points2);
        TrianglePyramid pyramid3 = new TrianglePyramid(UUID.randomUUID(), points3);
        TrianglePyramid pyramid4 = new TrianglePyramid(UUID.randomUUID(), points4);
        TrianglePyramid pyramid5 = new TrianglePyramid(UUID.randomUUID(), points5);
        TrianglePyramid pyramid6 = new TrianglePyramid(UUID.randomUUID(), points6);
        PyramidRepository repository = PyramidRepository.getInstance();
        repository.add(pyramid1);
        repository.add(pyramid2);
        repository.add(pyramid3);
        repository.add(pyramid4);
        repository.add(pyramid5);
        repository.add(pyramid6);
        repository.query(specification);
    }

    @Test
    public void queryTest2() {
        Specification<Pyramid> specification = new PyramidIdSpecification<>(UUID.fromString("76304b84-9b60-46ba-b7e6-abb79e1b2353"));
        Point point1 = new Point(2.0, 6.0, 7.0);
        Point point2 = new Point(4.0, 6.0, 7.0);
        Point point3 = new Point(2.0, 8.0, 7.0);
        Point point4 = new Point(2.0, 6.0, 10.0);
        List<Point> points1 = List.of(point1, point2, point3, point4);
        point1 = new Point(5.0, 3.0, 0.0);
        point2 = new Point(7.0, 6.0, 0.0);
        point3 = new Point(2.0, 8.0, 0.0);
        point4 = new Point(1.0, 6.0, 5.0);
        List<Point> points2 = List.of(point1, point2, point3, point4);
        point1 = new Point(12.0, 1.0, -7.0);
        point2 = new Point(1.0, 16.0, -7.0);
        point3 = new Point(3.0, 8.0, -7.0);
        point4 = new Point(11.0, 16.0, 0.0);
        List<Point> points3 = List.of(point1, point2, point3, point4);
        point1 = new Point(21.0, 0.0, 0.0);
        point2 = new Point(-34.0, 15.0, 0.0);
        point3 = new Point(-12.0, 18.0, 0.0);
        point4 = new Point(1.0, 3.0, 1.0);
        List<Point> points4 = List.of(point1, point2, point3, point4);
        point1 = new Point(12.0, -6.0, 5.0);
        point2 = new Point(14.0, 6.0, 5.0);
        point3 = new Point(24.0, -8.0, 5.0);
        point4 = new Point(2.0, 0.0, 15.0);
        List<Point> points5 = List.of(point1, point2, point3, point4);
        point1 = new Point(5.0, 3.0, 1.0);
        point2 = new Point(7.0, 6.0, 1.0);
        point3 = new Point(2.0, 8.0, 1.0);
        point4 = new Point(1.0, 6.0, 5.0);
        List<Point> points6 = List.of(point1, point2, point3, point4);
        TrianglePyramid pyramid1 = new TrianglePyramid(UUID.randomUUID(), points1);
        TrianglePyramid pyramid2 = new TrianglePyramid(UUID.randomUUID(), points2);
        TrianglePyramid pyramid3 = new TrianglePyramid(UUID.fromString("76304b84-9b60-46ba-b7e6-abb79e1b2353"), points3);
        TrianglePyramid pyramid4 = new TrianglePyramid(UUID.randomUUID(), points4);
        TrianglePyramid pyramid5 = new TrianglePyramid(UUID.randomUUID(), points5);
        TrianglePyramid pyramid6 = new TrianglePyramid(UUID.randomUUID(), points6);
        PyramidRepository repository = PyramidRepository.getInstance();
        repository.add(pyramid1);
        repository.add(pyramid2);
        repository.add(pyramid3);
        repository.add(pyramid4);
        repository.add(pyramid5);
        repository.add(pyramid6);
        repository.query(specification);
    }

    @Test
    public void queryTest3() {
        Specification<Pyramid> specification = new PyramidTypeSpecification(Pyramid.PyramidType.TRIANGLE_PYRAMID);
        Point point1 = new Point(2.0, 6.0, 7.0);
        Point point2 = new Point(4.0, 6.0, 7.0);
        Point point3 = new Point(2.0, 8.0, 7.0);
        Point point4 = new Point(2.0, 6.0, 10.0);
        List<Point> points1 = List.of(point1, point2, point3, point4);
        point1 = new Point(5.0, 3.0, 0.0);
        point2 = new Point(7.0, 6.0, 0.0);
        point3 = new Point(2.0, 8.0, 0.0);
        point4 = new Point(1.0, 6.0, 5.0);
        List<Point> points2 = List.of(point1, point2, point3, point4);
        point1 = new Point(12.0, 1.0, -7.0);
        point2 = new Point(1.0, 16.0, -7.0);
        point3 = new Point(3.0, 8.0, -7.0);
        point4 = new Point(11.0, 16.0, 0.0);
        List<Point> points3 = List.of(point1, point2, point3, point4);
        point1 = new Point(21.0, 0.0, 0.0);
        point2 = new Point(-34.0, 15.0, 0.0);
        point3 = new Point(-12.0, 18.0, 0.0);
        point4 = new Point(1.0, 3.0, 1.0);
        List<Point> points4 = List.of(point1, point2, point3, point4);
        point1 = new Point(12.0, -6.0, 5.0);
        point2 = new Point(14.0, 6.0, 5.0);
        point3 = new Point(24.0, -8.0, 5.0);
        point4 = new Point(2.0, 0.0, 15.0);
        List<Point> points5 = List.of(point1, point2, point3, point4);
        point1 = new Point(5.0, 3.0, 1.0);
        point2 = new Point(7.0, 6.0, 1.0);
        point3 = new Point(2.0, 8.0, 1.0);
        point4 = new Point(1.0, 6.0, 5.0);
        List<Point> points6 = List.of(point1, point2, point3, point4);
        TrianglePyramid pyramid1 = new TrianglePyramid(UUID.randomUUID(), points1);
        TrianglePyramid pyramid2 = new TrianglePyramid(UUID.randomUUID(), points2);
        TrianglePyramid pyramid3 = new TrianglePyramid(UUID.randomUUID(), points3);
        TrianglePyramid pyramid4 = new TrianglePyramid(UUID.randomUUID(), points4);
        TrianglePyramid pyramid5 = new TrianglePyramid(UUID.randomUUID(), points5);
        TrianglePyramid pyramid6 = new TrianglePyramid(UUID.randomUUID(), points6);
        PyramidRepository repository = PyramidRepository.getInstance();
        repository.add(pyramid1);
        repository.add(pyramid2);
        repository.add(pyramid3);
        repository.add(pyramid4);
        repository.add(pyramid5);
        repository.add(pyramid6);
        repository.query(specification);
    }
}

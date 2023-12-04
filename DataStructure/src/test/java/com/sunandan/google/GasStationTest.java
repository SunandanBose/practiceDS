package com.sunandan.google;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class GasStationTest {
    private GasStation gs = new GasStation();

    @Test
    public void test1ShouldReturnFalse(){
        List<Integer> gasAvailableInStation = Arrays.asList(959, 329, 987, 951, 942, 410, 282, 376, 581, 507, 546, 299, 564, 114, 474, 163, 953, 481, 337, 395, 679, 21, 335, 846, 878, 961, 663, 413, 610, 937, 32, 831, 239, 899, 659, 718, 738, 7, 209);
        List<Integer> gasNeededToTravelNextStation = Arrays.asList(862, 783, 134, 441, 177, 416, 329, 43, 997, 920, 289, 117, 573, 672, 574, 797, 512, 887, 571, 657, 420, 686, 411, 817, 185, 326, 891, 122, 496, 905, 910, 810, 226, 462, 759, 637, 517, 237, 884);
        assertEquals(-1, gs.getMinimumStartingGasStation(gasAvailableInStation,gasNeededToTravelNextStation));
    }
    @Test
    public void test2ShouldReturnFalse(){
        List<Integer> gasAvailableInStation = Arrays.asList(684, 57, 602, 987);
        List<Integer> gasNeededToTravelNextStation = Arrays.asList(909, 535, 190, 976);
        assertEquals(-1, gs.getMinimumStartingGasStation(gasAvailableInStation,gasNeededToTravelNextStation));
    }

    @Test
    public void test2ShouldReturn37(){
        List<Integer> gasAvailableInStation = Arrays.asList(237, 573, 278, 782, 819, 548, 14, 670, 81, 178, 448, 889, 200, 541, 582, 111, 718, 236, 292, 850, 536, 654, 230, 551, 917, 788, 531, 26, 206, 960, 381, 183, 207, 44, 141, 252, 74, 890, 857, 834, 396, 569, 597, 538, 370, 876, 481, 307, 643, 138, 652, 676, 340, 590, 565, 857, 584, 275, 703, 508, 388, 454, 944, 670);
        List<Integer> gasNeededToTravelNextStation = Arrays.asList(316, 803, 374, 899, 361, 548, 430, 366, 137, 993, 751, 9, 52, 774, 449, 533, 870, 271, 829, 232, 529, 9, 167, 738, 779, 89, 515, 67, 649, 831, 508, 397, 914, 236, 134, 914, 129, 77, 372, 921, 527, 588, 249, 275, 23, 793, 321, 264, 30, 360, 29, 27, 96, 150, 746, 338, 921, 846, 719, 193, 565, 236, 92, 453);
        assertEquals(37, gs.getMinimumStartingGasStation(gasAvailableInStation,gasNeededToTravelNextStation));
    }
}